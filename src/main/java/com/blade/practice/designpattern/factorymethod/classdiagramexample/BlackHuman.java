package com.blade.practice.designpattern.factorymethod.classdiagramexample;

/**
 * TODO:
 *
 * @author Blade
 * @date 2019/3/24 10:32
 */
public class BlackHuman implements Human {
    @Override
    public void getColor() {
        System.out.println("i am black");
    }

    @Override
    public void talk() {
        System.out.println("i am speak fei zhou hua");
    }
}
