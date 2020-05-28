package com.blade.practice.designpattern.proxy.classdiagram;

/**
 * TODO:
 *
 * @author Blade
 * @date 2019/4/11 16:28
 */
public class CProxy implements CSubject {
    private CSubject subject = null;


    public CProxy(CSubject subject) {
        this.subject = subject;
    }

    @Override
    public void request() {
        this.before();
        this.subject.request();
        this.after();
    }

    private void before() {
        System.out.println("this is proxy before do");
    }

    private void after() {
        System.out.println("this is proxy after do");
    }

}
