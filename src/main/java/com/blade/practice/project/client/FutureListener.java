package com.blade.practice.project.client;

import com.blade.practice.project.exception.ServiceException;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * TODO:
 *
 * @author blade
 * 2021/5/29 13:19
 */
public class FutureListener extends CompletableFuture<Boolean> implements Listener{

    private final Listener listener;

    private final AtomicBoolean started;

    public FutureListener(AtomicBoolean started) {
        this.started = started;
        this.listener = null;
    }

    public FutureListener(Listener listener, AtomicBoolean started) {
        this.listener = listener;
        this.started = started;
    }

    @Override
    public void onSuccess(Object... args) {
        if(super.isDone()) {
            // 防止 Listener 被重复执行
            return;
        }
        complete(started.get());
        if (null != this.listener) {
            listener.onSuccess(args);
        }
    }

    @Override
    public void onFailure(Throwable cause) {
        if(super.isDone()) {
            // 防止 Listener 被重复执行
            return;
        }
        completeExceptionally(cause);
        if (null != this.listener) {
            listener.onFailure(cause);
        }
        throw cause instanceof ServiceException ? (ServiceException) cause : new ServiceException(cause);
    }
}
