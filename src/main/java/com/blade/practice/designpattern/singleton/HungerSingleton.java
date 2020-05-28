package com.blade.practice.designpattern.singleton;

/**
 * TODO:
 * 饿汉式单例
 * @author Blade
 * @date 2019/3/23 12:18
 */
public class HungerSingleton {

    private static HungerSingleton hungerSingleton = new HungerSingleton();

    private HungerSingleton(){};

    public static HungerSingleton getInstance() {
        return hungerSingleton;
    }
}
