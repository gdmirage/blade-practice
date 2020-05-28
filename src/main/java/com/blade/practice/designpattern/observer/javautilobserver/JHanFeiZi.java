package com.blade.practice.designpattern.observer.javautilobserver;

import java.util.Observable;

/**
 * TODO:
 *
 * @author Blade
 * @date 2019/3/29 22:48
 */
public class JHanFeiZi extends Observable implements IJHanFeiZi{
    @Override
    public void haveBreakfast() {
        System.out.println("韩非子正在吃饭");
        super.setChanged();
        super.notifyObservers("吃饭");
        System.out.println("啦啦");
    }

    @Override
    public void haveFun() {
        System.out.println("韩非子正在娱乐");
        super.setChanged();
        super.notifyObservers("娱乐");
        System.out.println("Oops");
    }
}
