package com.blade.practice.project.client;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFactory;
import io.netty.channel.EventLoopGroup;

import java.util.concurrent.CompletableFuture;

/**
 * TODO:
 *
 * @author blade
 * 2021/5/29 10:49
 */
public class NettyTcpClient implements Client{

    void createClient(Listener listener, EventLoopGroup workGroup, ChannelFactory<? extends Channel> factory) {

    }

    @Override
    public boolean isRunning() {
        return false;
    }

    @Override
    public void start(Listener listener) {

    }

    @Override
    public void stop(Listener listener) {

    }

    @Override
    public CompletableFuture<Boolean> start() {
        return null;
    }

    @Override
    public CompletableFuture<Boolean> stop() {
        return null;
    }

    @Override
    public boolean syncStart() {
        return false;
    }

    @Override
    public boolean syncStop() {
        return false;
    }

    @Override
    public void init() {

    }
}
