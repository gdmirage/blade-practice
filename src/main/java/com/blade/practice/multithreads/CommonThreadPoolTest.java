package com.blade.practice.multithreads;

import java.io.IOException;

/**
 * @author Blade
 * @date 2019-07-04 18:34:40
 **/
public class CommonThreadPoolTest {

    public static void main(String[] args) throws IOException {
        Thread thread1 = new Thread1();
        Thread thread2 = new Thread2();

        CommonThreadPool.executeThread(thread1);
        CommonThreadPool.executeThread(thread2);

        System.in.read();
    }
}
