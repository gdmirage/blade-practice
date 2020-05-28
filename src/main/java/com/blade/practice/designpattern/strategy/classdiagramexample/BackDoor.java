package com.blade.practice.designpattern.strategy.classdiagramexample;

/**
 * TODO:
 *
 * @author Blade
 * @date 2019/3/28 11:11
 */
public class BackDoor implements ICStrategy {
    @Override
    public void operate() {
        System.out.println("第一个锦囊:找乔国老帮忙，走后面");
    }
}
