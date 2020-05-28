package com.blade.practice.designpattern.factorymethod.classdiagramexample;

/**
 * TODO:
 *
 * @author Blade
 * @date 2019/3/24 10:29
 */
public class YellowHuman implements Human {
    @Override
    public void getColor() {
        System.out.println("i am yellow");
    }

    @Override
    public void talk() {
        System.out.println("i am speak chinese");
    }
}
