package com.blade.practice.producer.arrayblockqueue;

/**
 * TODO:
 *
 * @author Blade
 * @date 2019/4/10 22:57
 */
public class BProducer {

    public static void produce() {

        new Thread(){
            @Override
            public void run() {
                int i = 0;
                while (true) {
                    try {
                        BQueue.queue.put(i);
                        System.out.println(String.format("已经放进了-->%s 个", BQueue.queue.size()));
                        i++;
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();


    }
}
