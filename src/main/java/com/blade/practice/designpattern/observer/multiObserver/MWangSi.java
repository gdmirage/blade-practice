package com.blade.practice.designpattern.observer.multiObserver;

/**
 * TODO:
 *
 * @author Blade
 * @date 2019/3/29 21:22
 */
public class MWangSi implements IMObserver {
    @Override
    public void update(String context) {
        System.out.println("王斯观察到韩非子活动");
        this.cry(context);
        System.out.println("王斯哭完就吃饭");
    }

    private void cry(String context) {
        System.out.println("王斯因为韩非子 -> " + context + " ，开始痛哭");
    }
}
