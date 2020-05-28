package com.blade.practice.designpattern.singleton;

/**
 * TODO:
 * 懒汉式单例
 * @author Blade
 * @date 2019/3/23 12:03
 */
public class LazySingleton {

    private LazySingleton(){};

    private static LazySingleton lazySingleton = null;

    public static LazySingleton getInstance(){
        if (null == lazySingleton) {
            synchronized (LazySingleton.class) {
                if (null == lazySingleton) {
                    lazySingleton = new LazySingleton();
                }
            }
        }

        return lazySingleton;
    }
}
