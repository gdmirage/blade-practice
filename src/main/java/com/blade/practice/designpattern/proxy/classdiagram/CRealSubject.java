package com.blade.practice.designpattern.proxy.classdiagram;

/**
 * TODO:
 *
 * @author Blade
 * @date 2019/4/11 16:26
 */
public class CRealSubject implements CSubject {
    @Override
    public void request() {
        System.out.println("i am real subject, need proxy to do my thing");
    }
}
