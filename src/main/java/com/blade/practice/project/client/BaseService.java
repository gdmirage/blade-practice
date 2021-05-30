package com.blade.practice.project.client;

import io.netty.util.concurrent.FutureListener;

import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

/**
 * TODO:
 *
 * @author blade
 * 2021/5/29 10:39
 */
public class BaseService implements Service {

    void tryStart(Listener listener, Function function) {

    }

    void tryStop(Listener listener, Function function) {

    }

    void doStart(Listener listener) {

    }

    void doStop(Listener listener) {

    }

    boolean throwIfStarted() {
        return false;
    }

    boolean throwIfStopped() {
        return false;
    }

    int timeoutMillis() {
        return 0;
    }

    FutureListener wrap(Listener listener) {
        return null;
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

    @Override
    public boolean isRunning() {
        return false;
    }
}
