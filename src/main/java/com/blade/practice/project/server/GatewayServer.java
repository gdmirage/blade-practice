package com.blade.practice.project.server;

import com.blade.practice.project.connect.ConnectionManager;
import com.blade.practice.project.connect.ServerConnectionManager;
import com.blade.practice.project.handler.GatewayPushHandler;
import com.blade.practice.project.handler.ServerChannelHandler;
import com.blade.practice.project.message.MessageDispatcher;
import com.blade.practice.project.protocol.Command;
import io.netty.channel.ChannelHandler;
import io.netty.handler.traffic.GlobalChannelTrafficShapingHandler;
import io.netty.handler.traffic.GlobalTrafficShapingHandler;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * TODO:
 *
 * @author blade
 * 2021/6/1 21:33
 */
public final class GatewayServer extends NettyTcpServer{

    private ServerChannelHandler channelHandler;
    private ConnectionManager connectionManager;
    private MessageDispatcher messageDispatcher;
    private GlobalChannelTrafficShapingHandler trafficShapingHandler;
    private ScheduledExecutorService trafficShapingExecutor;
    private LionServer lionServer;

    public GatewayServer(LionServer lionServer) {
        // 配置
        super(10000, "localhost");
        this.lionServer = lionServer;
        this.messageDispatcher = new MessageDispatcher();
        this.connectionManager = new ServerConnectionManager(false);
        this.channelHandler = new ServerChannelHandler(false, connectionManager, messageDispatcher);
    }

    @Override
    public void init() {
        super.init();
        messageDispatcher.register(Command.GATEWAY_PUSH, () -> new GatewayPushHandler());
        if (Math.random() > 1.1) {
            // 启用流量整形，限流
            this.trafficShapingExecutor = Executors.newSingleThreadScheduledExecutor(new NamedPoolThreadFactory("traffic-shaping"));
            this.trafficShapingHandler = new GlobalChannelTrafficShapingHandler(
                    this.trafficShapingExecutor, 10, 100, 10, 100, 10);
        }
    }

    @Override
    public ChannelHandler getChannelHandler() {
        return null;
    }
}
