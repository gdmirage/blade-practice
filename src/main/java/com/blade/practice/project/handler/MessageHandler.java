package com.blade.practice.project.handler;

import com.blade.practice.project.codec.Packet;
import com.blade.practice.project.connect.Connection;
import io.netty.channel.ChannelHandler;

/**
 * TODO:
 *
 * @author blade
 * 2021/6/1 10:57
 */
public interface MessageHandler extends ChannelHandler {

    void handle(Packet packet, Connection connection);
}
