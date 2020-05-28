package com.blade.practice.multithreads;

import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author Blade
 * @date 2019-07-04 18:28:18
 **/
public class CommonThreadPool {

    private static ThreadPoolExecutor threadPoolExecutor;

    static {
        ThreadPoolHelper threadPoolHelper = new ThreadPoolHelper("commonThreadPool");
        System.out.println("init common thread pool");
        threadPoolExecutor = threadPoolHelper.getExecutorPoolExecutor();
    }

    public static void executeThread(Thread thread) {
        threadPoolExecutor.execute(thread);
    }

    public static Future<?> submitThread(Thread thread) {
        return threadPoolExecutor.submit(thread);
    }
}
