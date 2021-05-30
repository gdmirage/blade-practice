package com.blade.practice.project.server;

import com.blade.practice.project.client.Listener;

import java.util.concurrent.CompletableFuture;

/**
 * TODO:
 *
 * @author blade
 * 2021/5/30 9:38
 */
public class LionServer implements Server{
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
