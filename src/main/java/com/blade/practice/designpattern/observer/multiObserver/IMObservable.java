package com.blade.practice.designpattern.observer.multiObserver;

/**
 * TODO:
 *
 * @author Blade
 * @date 2019/3/29 21:04
 */
public interface IMObservable {

    void addObserver(IMObserver observer);

    void deleteObserver(IMObserver observer);

    void notifyObserver(String context);
}
