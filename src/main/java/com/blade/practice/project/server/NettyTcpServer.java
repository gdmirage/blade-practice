package com.blade.practice.project.server;

import com.blade.practice.project.client.BaseService;
import com.blade.practice.project.client.Listener;
import com.blade.practice.project.codec.PacketDecoder;
import com.blade.practice.project.codec.PacketEncoder;
import com.blade.practice.project.exception.ServiceException;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFactory;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.ServerChannel;
import io.netty.channel.nio.NioEventLoopGroup;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;
import java.nio.channels.spi.SelectorProvider;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicReference;

/**
 * TODO:
 *
 * @author blade
 * 2021/5/29 11:09
 */
public abstract class NettyTcpServer extends BaseService implements Server {

    private final static Logger logger = LoggerFactory.getLogger(NettyTcpServer.class);

    protected final AtomicReference<State> serverState = new AtomicReference<>();

    protected final int port;
    protected final String host;
    protected EventLoopGroup bossGroup;
    protected EventLoopGroup workerGroup;

    private ChannelHandler channelHandler;

    private boolean running;

    private SelectorProvider selectorProvider;

    private ChannelFactory<? extends ServerChannel> channelFactory;

    public NettyTcpServer(int port) {
        this.port = port;
        this.host = null;
    }

    public NettyTcpServer(int port, String host) {
        this.port = port;
        this.host = host;
    }

    public void init() {
        if (!serverState.compareAndSet(State.Created, State.Initialized)) {
            throw new ServiceException("Server already init");
        }
    }

    @Override
    public void stop(Listener listener) {
        if (!serverState.compareAndSet(State.Started, State.Shutdown)) {
            if (null != listener) {
                listener.onFailure(new ServiceException("server was already shutdown."));
            }
            logger.error("{} was already shutdown.", this.getClass().getSimpleName());
            return;
        }
        logger.info("try shutdown {}...", this.getClass().getSimpleName());
        if (null != bossGroup) {
            bossGroup.shutdownGracefully();
        }

        if (null != workerGroup) {
            workerGroup.shutdownGracefully();
        }

        logger.info("{} shutdown success", this.getClass().getSimpleName());
        if (null != listener) {
            listener.onSuccess(this.port);
        }
    }

    @Override
    public void start(Listener listener) {
        if (!serverState.compareAndSet(State.Initialized, State.Starting)) {
            throw new ServiceException("Server already started or have not init");
        }

        if (useNettyEpoll()) {
            createEpollServer(listener);
        } else {
            createNioServer(listener);
        }
    }

    static boolean useNettyEpoll() {
        if (useNettyEpollConfig()) {
            try {
                Class.forName("io.netty.channel.epoll.Native");
                return true;
            } catch (Exception e) {
                logger.warn("can not load netty epoll, switch nio model.");
            }
        }
        return false;
    }

    static boolean useNettyEpollConfig() {
        // 只有在linux下才使用epoll
        String name = System.getProperty("os.name").toLowerCase();
        return name.startsWith("linux");
    }

    void createServer(Listener listener, EventLoopGroup bossGroup, EventLoopGroup workerGroup,
                      ChannelFactory<? extends ServerChannel> channelFactory) {
        /*
         * NioEventLoopGroup 是用来处理I/O操作多线程事件循环器，
         * Netty提供了许多不同的EventLoopGroup的实现用来不同传输协议。
         * 在一个服务端的应用会有2个NioEventLoopGroup会被使用。
         * 第一个经常被叫做'boss'，用来接收链接
         * 第一个经常被叫做'worker'，用来处理已经被接收的链接
         * 一旦'boss'接收到链接，就会把链接信息注册到'worker'上。
         * 如何知道多少个线程已经被使用，如何映射到已创建的Channels上都需要依赖于EventLoopGroup的实现，
         * 并且可以通过构造函数来配置他们的关系。
         */
        this.bossGroup = bossGroup;
        this.workerGroup = workerGroup;

        try {
            /*
             * ServerBootstrap 是一个启动NIO服务的辅助启动类
             * 你可以在这个服务中直接使用Channel
             */
            ServerBootstrap bootstrap = new ServerBootstrap();

            /*
             * 这一步是必须的，如果没有设置group将会报异常 : group not set
             */
            bootstrap.group(bossGroup, workerGroup);

            /*
             * ServerSocketChannel以NIO的selector为基础实现的，用来接收新的连接
             */
            bootstrap.channelFactory(channelFactory);

            /*
             * 这里的事件处理类经常会被用来处理一个最近的已经接收到Channel。
             * ChannelInitializer是一个特殊的处理类，
             * 他的目的是帮助使用者配置一个新的Channel。
             * 也许你想通过增加一些处理类，比如NettyServerHandler来配置一个新的Channel
             * 或者其对应的 ChannelPipeline 来实现你的网络程序。
             * 当你的程序变的复杂时，可能你会增加更多的处理类到 pipeline 上，
             * 然后提取这些匿名类到最顶层的类上。
             */
            bootstrap.childHandler(new ChannelInitializer<Channel>() {
                @Override
                protected void initChannel(Channel ch) throws Exception { //每连上一个连接调用一次
                    initPipeline(ch.pipeline());
                }
            });

            initOptions(bootstrap);

            /*
             * 绑定端口并启动去接收进来的连接
             */
            InetSocketAddress address = StringUtils.isBlank(this.host)
                    ? new InetSocketAddress(this.port) : new InetSocketAddress(this.host, this.port);
            bootstrap.bind(address).addListener(future -> {
                if (future.isSuccess()) {
                    this.serverState.set(State.Started);
                    this.logger.info("server start success on : {}", this.port);
                    if (null != listener) {
                        listener.onSuccess(this.port);
                    }
                } else {
                    this.logger.error("server start failure on : {}", this.port, future.cause());
                    if (null != listener) {
                        listener.onFailure(future.cause());
                    }
                }
            });
        } catch (Exception e) {
            logger.error("server start exception", e);
            if (null != listener) {
                listener.onFailure(e);
            }
            throw new ServiceException("server start exception, port=" + this.port, e);
        }
    }

    void createNioServer(Listener listener) {
        EventLoopGroup bossGroup = this.getBossGroup();
        EventLoopGroup workerGroup = this.getWorkerGroup();
        if (null == bossGroup) {
            NioEventLoopGroup nioEventLoopGroup = new NioEventLoopGroup(this.getBossThreadNum(),
                    this.getBossThreadFactory(), this.getSelectorProvider());
            nioEventLoopGroup.setIoRatio(100);
            bossGroup = nioEventLoopGroup;
        }

        if (null == workerGroup) {
            NioEventLoopGroup nioEventLoopGroup = new NioEventLoopGroup(this.getWorkThreadNum(),
                    this.getWorkThreadFactory(), this.getSelectorProvider());
            nioEventLoopGroup.setIoRatio(this.getIoRate());
            workerGroup = nioEventLoopGroup;
        }
    }

    void createEpollServer(Listener listener) {

    }

    /**
     * option() 是提供给 NioServerSocketChannel 用来接收到
     * childOption 是提供给由父管道 ServerChannel 接收到的连接，
     * 在这个例子中也是 NioServerSocketChannel 。
     *
     * @param bootstrap {@link ServerBootstrap}
     */
    protected void initOptions(ServerBootstrap bootstrap) {
        /*
         * 在Netty 4中实现了一个新的ByteBuf内存池，它是一个纯Java版的 jemalloc (Facebook也在用)。
         * 现在，Netty不会再因为用零填充缓冲区而浪费内存带宽了。不过，由于它不依赖GC，开发人员需要小心内存泄露。
         * 如果忘记在处理程序中释放缓冲区，那么内存使用率会无限地增长。
         * Netty默认不使用内存池，需要在创建客户端或者服务端的时候进行指定
         */
        bootstrap.option(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT);
        bootstrap.childOption(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT);
    }

    protected ChannelHandler getDecoder() {
        return new PacketDecoder();
    }

    protected ChannelHandler getEncoder() {
        // 每个链接调用一次， 所有用单例
        return PacketEncoder.INSTANCE;
    }

    void initPipeline(ChannelPipeline channelPipeline) {

    }

    ThreadFactory getBossThreadFactory() {
        return null;
    }

    ThreadFactory getWorkThreadFactory() {
        return null;
    }

    int getBossThreadNum() {
        return 0;
    }

    int getWorkThreadNum() {
        return 0;
    }

    String getBossThreadName() {
        return "boss";
    }

    String getWorkThreadName() {
        return "work";
    }

    int getIoRate() {
        return 0;
    }

    public abstract ChannelHandler getChannelHandler();

    public void setChannelHandler(ChannelHandler channelHandler) {
        this.channelHandler = channelHandler;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public SelectorProvider getSelectorProvider() {
        return selectorProvider;
    }

    public void setSelectorProvider(SelectorProvider selectorProvider) {
        this.selectorProvider = selectorProvider;
    }

    public EventLoopGroup getBossGroup() {
        return bossGroup;
    }

    public void setBossGroup(EventLoopGroup bossGroup) {
        this.bossGroup = bossGroup;
    }

    public ChannelFactory<? extends ServerChannel> getChannelFactory() {
        return channelFactory;
    }

    public void setChannelFactory(ChannelFactory<? extends ServerChannel> channelFactory) {
        this.channelFactory = channelFactory;
    }

    public EventLoopGroup getWorkerGroup() {
        return workerGroup;
    }

    public void setWorkerGroup(EventLoopGroup workerGroup) {
        this.workerGroup = workerGroup;
    }

    public enum State {
        Created, Initialized, Starting, Started, Shutdown
    }
}
