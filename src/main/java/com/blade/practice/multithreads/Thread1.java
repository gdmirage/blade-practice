package com.blade.practice.multithreads;

/**
 * @author Blade
 * @date 2019-07-04 18:40:05
 **/
public class Thread1 extends Thread {

    @Override
    public void run() {
        this.setName("Thread-1");
        System.out.println(Thread.currentThread().getName() + "this is thread 1");
    }
}
