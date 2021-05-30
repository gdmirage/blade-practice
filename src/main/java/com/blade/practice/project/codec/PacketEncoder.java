package com.blade.practice.project.codec;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;

/**
 * TODO:
 *
 * @author blade
 * 2021/5/29 12:54
 */
public class PacketEncoder implements ChannelHandler {

    public static PacketEncoder INSTANCE;

    public PacketEncoder() {
        INSTANCE = new PacketEncoder();
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
