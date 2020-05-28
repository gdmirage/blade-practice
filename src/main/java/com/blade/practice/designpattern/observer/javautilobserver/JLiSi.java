package com.blade.practice.designpattern.observer.javautilobserver;

import java.util.Observable;
import java.util.Observer;

/**
 * TODO:
 *
 * @author Blade
 * @date 2019/3/29 23:16
 */
public class JLiSi implements Observer {
    @Override
    public void update(Observable observable, Object obj) {
        System.out.println("李斯的观察者正在报告");
        reportToQinShiHuang(obj.toString());
        System.out.println("李斯报告完毕");
    }

    private void reportToQinShiHuang(String context) {
        System.out.println("报告，韩非子正在:" + context);
    }
}
