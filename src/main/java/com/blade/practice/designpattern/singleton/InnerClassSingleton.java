package com.blade.practice.designpattern.singleton;

/**
 * TODO:
 * 内部类单例
 * @author Blade
 * @date 2019/3/23 12:28
 */
public class InnerClassSingleton {

    private InnerClassSingleton(){}

    private static class InnerClassSingletonHolder{

        private static InnerClassSingleton singleton;
        static {
            System.out.println("InnerClassSingletonHolder static method");
            singleton = new InnerClassSingleton();
        }
    }

    public static InnerClassSingleton getInstance() {
        return InnerClassSingletonHolder.singleton;
    }

}
