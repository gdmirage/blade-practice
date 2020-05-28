package com.blade.practice.multithreads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * TODO:
 *
 * @author Blade
 * @date 2019/3/19 10:01
 */
public class ThreadPoolHelper {

    private final int CORE_POOL_SIZE = 5;
    private final int MAX_POOL_SIZE = 10;
    private final long KEEP_ALIVE_TIME = 1000;

    private final BlockingQueue<Runnable> WORK_QUEUE = new ArrayBlockingQueue<Runnable>(1024);

    private ThreadFactory threadFactory;

    private String threadName;

    public ThreadPoolHelper(String threadName) {
        this.threadName = threadName;
    }

    public ThreadPoolExecutor getExecutorPoolExecutor() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME, TimeUnit.MILLISECONDS, WORK_QUEUE, getThreadFactory());
        return threadPoolExecutor;
    }

    private ThreadFactory getThreadFactory() {
        return new NamedThreadFactory(threadName);
    }
}
