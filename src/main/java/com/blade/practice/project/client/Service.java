package com.blade.practice.project.client;

import java.util.concurrent.CompletableFuture;

/**
 * TODO:
 *
 * @author blade
 * 2021/5/29 10:31
 */
public interface Service {

    boolean isRunning();

    void start(Listener listener);

    void stop(Listener listener);

    CompletableFuture<Boolean> start();

    CompletableFuture<Boolean> stop();

    boolean syncStart();

    boolean syncStop();

    void init();
}
