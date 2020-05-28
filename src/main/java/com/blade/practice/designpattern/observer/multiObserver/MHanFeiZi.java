package com.blade.practice.designpattern.observer.multiObserver;

import java.util.ArrayList;

/**
 * TODO:
 *
 * @author Blade
 * @date 2019/3/29 21:16
 */
public class MHanFeiZi implements IMObservable, IMHanFeiZi {

    private ArrayList<IMObserver> observers = new ArrayList<>();

    @Override
    public void addObserver(IMObserver observer) {
        observers.add(observer);
    }

    @Override
    public void deleteObserver(IMObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver(String context) {
        observers.forEach(observer -> {
            observer.update(context);
        });
    }

    @Override
    public void haveBreakfast() {
        System.out.println("韩非子开始吃饭了");
        this.notifyObserver("韩非子在吃饭");
    }

    @Override
    public void haveFun() {
        System.out.println("韩非子开始娱乐了");
        this.notifyObserver("韩非子在娱乐");
    }
}
