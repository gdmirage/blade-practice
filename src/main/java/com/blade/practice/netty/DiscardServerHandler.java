package com.blade.practice.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * TODO:
 *
 * @author Blade
 * @date 2020/4/24 9:34
 */
public class DiscardServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("My DiscardServerHandler channelRead");
        ((ByteBuf) msg).release();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("My DiscardServerHandler exceptionCaught");
        cause.printStackTrace();
        ctx.close();
    }
}
