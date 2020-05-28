package com.blade.practice.designpattern.proxy.advice;

/**
 * TODO:
 *
 * @author Blade
 * @date 2019/4/12 11:49
 */
public class ARealSubject implements ASubject {
    @Override
    public void doSomething(String str) {
        System.out.println(String.format("i am real subject, doing %s", str));
    }
}
