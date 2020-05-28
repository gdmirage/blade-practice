package com.blade.practice.designpattern.singleton;

/**
 * TODO:
 *
 * @author Blade
 * @date 2019/3/23 12:03
 */
public class SingletonTest {

    public static void main(String[] args) {
//        lazySingletonTest();
//        hungerSingletonTest();

        innerClassSingletonTest();
    }

    private static void lazySingletonTest() {
        for (int i = 0; i < 100; i++) {
            Thread t = new Thread(()->{
                LazySingleton singleton = LazySingleton.getInstance();
                System.out.println(Thread.currentThread().getName() + "-->" + singleton);
            });

            t.setName("lazy Singleton " + i);
            t.start();
        }
    }

    private static void hungerSingletonTest() {
        for (int i = 0; i < 100; i++) {
            Thread t = new Thread(() -> {
                HungerSingleton singleton = HungerSingleton.getInstance();
                System.out.println(Thread.currentThread().getName() + "-->" + singleton);
            });
            t.setName("hunger Singleton " + i);
            t.start();
        }
    }

    private static void innerClassSingletonTest() {
        for (int i = 0; i < 100; i++) {
            Thread t = new Thread(() -> {
                InnerClassSingleton singleton = InnerClassSingleton.getInstance();
                System.out.println(Thread.currentThread().getName() + "-->" + singleton);
            });
            t.setName("inner class Singleton " + i);
            t.start();
        }
    }
}
