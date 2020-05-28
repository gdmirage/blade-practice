package com.blade.practice.producer.arrayblockqueue;

/**
 * TODO:
 *
 * @author Blade
 * @date 2019/4/10 23:01
 */
public class BConsumer {

    public static void consumer() {

        new Thread(){
            @Override
            public void run() {
                while (true) {
                    try {
                        Object o = BQueue.queue.take();
                        System.out.println(String.format("拿到了-->%s", o));
                        System.out.println(String.format("还剩下-->%s 个", BQueue.queue.size()));
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}
