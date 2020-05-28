package com.blade.practice.designpattern.observer.multiObserver;

/**
 * TODO:
 *
 * @author Blade
 * @date 2019/3/29 21:24
 */
public class MLiuSi implements IMObserver {
    @Override
    public void update(String context) {
        System.out.println("刘斯观察到韩非子活动");
        this.happy(context);
        System.out.println("刘斯非常高兴");
    }

    private void happy(String context) {
        System.out.println("刘斯因为韩非子 -> " + context + " ,很快乐");
    }
}
