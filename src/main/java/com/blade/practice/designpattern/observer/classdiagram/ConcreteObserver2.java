package com.blade.practice.designpattern.observer.classdiagram;

/**
 * TODO:
 *
 * @author Blade
 * @date 2019/3/28 23:34
 */
public class ConcreteObserver2 implements IObserver {
    @Override
    public void update() {
        System.out.println("this is concrete observer two, dealing messages");
    }
}
