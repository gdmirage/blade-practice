package com.blade.practice.multithreads;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * TODO:
 *
 * @author Blade
 * @date 2019/3/19 10:48
 */
public class CyclicBarrierExample {

    private static final int THREAD_COUNT = 50;

    private static final CyclicBarrier CYCLIC_BARRIER = new CyclicBarrier(5);

    public static void main(String[] args) throws Exception {
        example1();
    }

    private static void example1() throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolHelper("CyclicBarrierExample-")
                .getExecutorPoolExecutor();

        for (int i = 0; i < THREAD_COUNT; i++) {
            final int threadNum = i;
            Thread.sleep(1000);
            threadPoolExecutor.execute(() -> {
                try {
                    test(threadNum);
                } catch (InterruptedException | BrokenBarrierException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            });
        }
        threadPoolExecutor.shutdown();
    }

    public static void test(int threadNum) throws InterruptedException, BrokenBarrierException {
        System.out.println(" thread num : " + threadNum + "is ready");
        try {
            /*等待60秒，保证子线程完全执行结束*/
            CYCLIC_BARRIER.await(60, TimeUnit.SECONDS);
        } catch (Exception e) {
            System.out.println("-----CyclicBarrierException------");
        }
        System.out.println(Thread.currentThread().getName() + " thread num : " + threadNum + "is finish");
    }
}
