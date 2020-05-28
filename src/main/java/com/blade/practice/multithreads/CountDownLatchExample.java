package com.blade.practice.multithreads;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * TODO:
 *
 * @author Blade
 * @date 2019/3/19 9:33
 */
public class CountDownLatchExample {

    private static final int THREAD_COUNT = 50;

    private static final CyclicBarrier CYCLIC_BARRIER = new CyclicBarrier(5);

    public static void main(String[] args) throws Exception {
        example1();
    }

    private static void example1() throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolHelper("CountDownLatchExample-")
                .getExecutorPoolExecutor();
        final CountDownLatch countDownLatch = new CountDownLatch(THREAD_COUNT);

        for (int i = 0; i < THREAD_COUNT; i++) {
            int threadNum = i;

            threadPoolExecutor.execute(() -> {
                try {
                    System.out.println("当前线程数量: " + threadPoolExecutor.getQueue().size());
                    test(threadNum);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }
            });
        }

        countDownLatch.await();
        threadPoolExecutor.shutdown();
        System.out.println("finish");
    }

    private static void test(int threadNum) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName() + " thread num : " + threadNum);
        Thread.sleep(1000);
    }
}
