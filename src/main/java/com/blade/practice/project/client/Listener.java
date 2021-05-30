package com.blade.practice.project.client;

/**
 * TODO:
 *
 * @author blade
 * 2021/5/29 11:10
 */
public interface Listener {

    void onSuccess(Object... args);

    void onFailure(Throwable cause);
}
