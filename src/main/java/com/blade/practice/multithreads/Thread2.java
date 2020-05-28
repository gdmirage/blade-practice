package com.blade.practice.multithreads;

import java.util.concurrent.TimeUnit;

/**
 * @author Blade
 * @date 2019-07-04 18:40:05
 **/
public class Thread2 extends Thread {

    @Override
    public void run() {
        this.setName("Thread-2");
        while (true) {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "this is thread 2");
        }
    }
}
