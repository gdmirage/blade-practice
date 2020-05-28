package com.blade.practice.designpattern.strategy.classdiagram;

/**
 * TODO:
 * 策略2，实现策略接口
 * @author Blade
 * @date 2019/3/28 11:04
 */
public class ConcreteStrategy2 implements Strategy {
    @Override
    public void doSomething() {
        System.out.println("this is concrete strategy two method");
    }
}
