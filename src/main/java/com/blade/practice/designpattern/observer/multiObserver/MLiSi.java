package com.blade.practice.designpattern.observer.multiObserver;

/**
 * TODO:
 *
 * @author Blade
 * @date 2019/3/29 21:20
 */
public class MLiSi implements IMObserver {
    @Override
    public void update(String context) {
        System.out.println("李斯开始汇报");
        this.reportToQinShiHuang(context);
        System.out.println("李斯汇报完毕");
    }

    private void reportToQinShiHuang(String context) {
        System.out.println("向秦始皇汇报");
    }
}
