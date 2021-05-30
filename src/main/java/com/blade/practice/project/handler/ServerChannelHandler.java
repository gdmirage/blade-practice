package com.blade.practice.project.handler;

import com.blade.practice.project.connect.ConnectionManager;
import com.blade.practice.project.message.MessageDispatcher;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;

/**
 * TODO:
 *
 * @author blade
 * 2021/5/30 9:36
 */
public class ServerChannelHandler implements ChannelHandler {

    public ServerChannelHandler(boolean security, ConnectionManager connectionManager, MessageDispatcher messageDispatcher) {
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
