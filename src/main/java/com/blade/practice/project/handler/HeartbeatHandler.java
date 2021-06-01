package com.blade.practice.project.handler;

import com.blade.practice.project.codec.Packet;
import com.blade.practice.project.connect.Connection;
import com.blade.practice.project.connect.ServerConnectionManager;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TODO:
 *
 * @author blade
 * 2021/6/1 10:57
 */
public class HeartbeatHandler implements MessageHandler{
    private static final Logger LOGGER = LoggerFactory.getLogger(HeartbeatHandler.class);
    @Override
    public void handle(Packet packet, Connection connection) {
        connection.send(packet);
        LOGGER.info("ping -> pong, {}", connection);
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
