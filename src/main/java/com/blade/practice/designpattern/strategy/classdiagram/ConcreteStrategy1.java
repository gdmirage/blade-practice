package com.blade.practice.designpattern.strategy.classdiagram;

/**
 * TODO:
 * 策略1，实现策略接口
 * @author Blade
 * @date 2019/3/28 11:03
 */
public class ConcreteStrategy1 implements Strategy {
    @Override
    public void doSomething() {
        System.out.println("this is concrete strategy one method");
    }
}
