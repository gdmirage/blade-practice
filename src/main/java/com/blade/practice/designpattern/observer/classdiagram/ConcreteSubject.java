package com.blade.practice.designpattern.observer.classdiagram;

/**
 * TODO:
 *
 * @author Blade
 * @date 2019/3/28 23:36
 */
public class ConcreteSubject extends Subject {

    public void doSomething() {
        System.out.println("这里已经执行完成了我的任务了");
        super.notifyObservers();
    }
}
