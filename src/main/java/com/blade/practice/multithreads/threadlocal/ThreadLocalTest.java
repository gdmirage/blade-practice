package com.blade.practice.multithreads.threadlocal;

/**
 * TODO:
 *
 * @author Blade
 * @date 2019/4/22 10:32
 */
public class ThreadLocalTest {

    private static ThreadLocal<User> userThreadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        userThreadLocal.set(new User());
    }
}
