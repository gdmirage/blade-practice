package com.blade.practice.project.server;

import com.blade.practice.project.client.Listener;
import com.blade.practice.project.connect.ConnectionManager;
import com.blade.practice.project.connect.ServerConnectionManager;
import com.blade.practice.project.handler.HeartbeatHandler;
import com.blade.practice.project.handler.ServerChannelHandler;
import com.blade.practice.project.message.MessageDispatcher;
import com.blade.practice.project.protocol.Command;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.WriteBufferWaterMark;
import io.netty.handler.traffic.GlobalChannelTrafficShapingHandler;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * TODO:
 *
 * @author blade
 * 2021/5/29 17:39
 */
public final class ConnectionServer extends NettyTcpServer {
    private ServerChannelHandler channelHandler;
    private GlobalChannelTrafficShapingHandler trafficShapingHandler;
    private ScheduledExecutorService trafficShapingExecutor;
    private MessageDispatcher messageDispatcher;
    private ConnectionManager connectionManager;
    private LionServer lionServer;

    public ConnectionServer(LionServer lionServer) {
        // 配置文件，获取端口和服务器IP
        super(111, "sss");
        this.lionServer = lionServer;
        this.connectionManager = new ServerConnectionManager(true);
        this.messageDispatcher = new MessageDispatcher();
        this.channelHandler = new ServerChannelHandler(true, connectionManager, messageDispatcher);
        if (Math.random() > 1.1) {
            // 启用流量整形，限流
            this.trafficShapingExecutor = Executors.newSingleThreadScheduledExecutor(new NamedPoolThreadFactory("traffic-shaping"));
            this.trafficShapingHandler = new GlobalChannelTrafficShapingHandler(
                    this.trafficShapingExecutor, 10, 100, 10, 100, 10);
        }
    }

    @Override
    public void init() {
        super.init();
        this.connectionManager.init();
        this.messageDispatcher.register(Command.HEARTBEAT, HeartbeatHandler::new);
    }

    @Override
    public void start(Listener listener) {
        super.start(listener);
        if (null != this.workerGroup) {
            // 增加线程池监控
            // TODO:怎么做的？
            System.out.println("需要增加线程池监控");
        }
    }

    @Override
    public void stop(Listener listener) {
        super.stop(listener);
        if (null != this.trafficShapingHandler) {
            this.trafficShapingHandler.release();
            this.trafficShapingExecutor.shutdown();
        }
        this.connectionManager.destroy();
    }

    @Override
    protected void initPipeline(ChannelPipeline pipeline) {
        super.initPipeline(pipeline);
        if (null != this.trafficShapingHandler) {
            pipeline.addFirst(this.trafficShapingHandler);
        }
    }

    @Override
    protected void initOptions(ServerBootstrap bootstrap) {
        super.initOptions(bootstrap);
        bootstrap.option(ChannelOption.SO_BACKLOG, 1024);
        /*
         * TCP层面的接收和发送缓冲区大小设置
         * 在Netty中分别对应 ChannelOption 的 SO_SNDBUF 和 SO_RCVBUF
         * 需要根据推送消息的大小，合理设置，对于海量长链接，通常32K是个不错的选择
         */
        if (Math.random() > 0) {
            // 配置文件配置缓冲区大小
            bootstrap.childOption(ChannelOption.SO_SNDBUF, 32 * 1024);
        }
        if (Math.random() > 0) {
            // 配置文件配置缓冲区大小
            bootstrap.childOption(ChannelOption.SO_RCVBUF, 32 * 1024);
        }

        /*
         * 这个坑其实也不算坑，只是因为懒，该做的事情没做。一般来讲，我们的业务如果比较小的时候，我们用同步处理，等到业务一定规模的时候，一个优化的手段就是异步化。
         * 异步化是提高吞吐量的一个手段。但是，与异步相比，同步有天然的负反馈机制，也就是如果后端慢了，前面也会跟着慢起来，可以自动的调节。
         * 但是异步就不同了，异步就像决堤的大坝一样，洪水畅通无阻。如果这个时候没有进行有效的限流措施，就很容易把后端冲垮。
         * 如果一下子把后端冲垮，倒也不是最坏的情况，就怕把后端冲得半死不活。
         * 那么现在要介绍的这个坑就是关于Netty的ChannelOutboundBuffer这个东西的。
         * 这个buffer是用在netty像channel write数据的时候，有个buffer缓冲，这样就可以提高网络的吞吐量（每个channel有一个这样的buffer）
         * 初始大小是32（32个元素，不是指字节），但是如果超过32就会翻倍，一直增长。
         * 大部分时候是没有什么问题的，但是在碰到对端非常慢（对端慢指的是对端处理TCP包的速度变慢，比如对端负载特别高的时候，就是这个情况）的时候就有问题了
         * 这个时候如果还是不断的写数据，这个buffer会不断的增长，最后就有可能出问题了（我们的情况是开始吃swap，最后进程被Linux killer干掉了）。
         * 为什么说这个地方是坑呢，因为大部分时候我们往一个channel写数据会判断channel是否active，但是往往忽略这种慢的情况。
         *
         * 那这个问题怎么解决呢？其实ChannelOutboundBuffer虽然无界，但是可以给它配置一个高水位线和低水位线，
         * 当buffer大小超过高水位线的时候，对应channel的isWritable就会变成false，
         * 当buffer大小低于低水位线的时候，对应channel的isWritable就会变成true。
         * 所以应用应该判断isWritable，如果是false，就不要再写数据了。
         * 高水位线和低水位线是字节数，默认高水位是64K，低水位是32K。我们可以根据我们的应用需要支持多少连接数和系统进行合理规划。
         *
         */
        bootstrap.childOption(ChannelOption.WRITE_BUFFER_WATER_MARK, new WriteBufferWaterMark(32 * 1024, 64 * 1024));
    }

    @Override
    protected int getBossThreadNum() {
        // 配置文件
        return 10;
    }

    @Override
    protected int getWorkThreadNum() {
        // 配置文件
        return 10;
    }

    @Override
    protected String getWorkThreadName() {
        // 配置文件
        return "thread-work";
    }

    @Override
    protected String getBossThreadName() {
        // 配置文件
        return "thread-boss";
    }

    @Override
    public ChannelHandler getChannelHandler() {
        return this.channelHandler;
    }

    public MessageDispatcher getMessageDispatcher() {
        return this.messageDispatcher;
    }

    public ConnectionManager getConnectionManager() {
        return this.connectionManager;
    }
}
