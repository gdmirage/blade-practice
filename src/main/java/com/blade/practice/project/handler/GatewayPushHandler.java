package com.blade.practice.project.handler;

import com.blade.practice.project.codec.Packet;
import com.blade.practice.project.connect.Connection;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TODO:
 *
 * @author blade
 * 2021/6/1 21:38
 */
public class GatewayPushHandler implements MessageHandler{
    private static final Logger LOGGER = LoggerFactory.getLogger(GatewayPushHandler.class);
    @Override
    public void handle(Packet packet, Connection connection) {
        connection.send(packet);
        LOGGER.info("push to gateway finish, {}", connection);
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {

    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {

    }
}
