package com.blade.practice.designpattern.observer.classdiagram;

import java.util.Vector;

/**
 * TODO:
 *
 * @author Blade
 * @date 2019/3/28 23:31
 */
public abstract class Subject {

    private Vector<IObserver> IObserverVector = new Vector<>();

    public void addObserver(IObserver IObserver) {
        this.IObserverVector.add(IObserver);
    }

    public void delObserver(IObserver IObserver) {
        this.IObserverVector.remove(IObserver);
    }

    public void notifyObservers() {
        for (IObserver IObserver : IObserverVector) {
            IObserver.update();
        }
    }

}
