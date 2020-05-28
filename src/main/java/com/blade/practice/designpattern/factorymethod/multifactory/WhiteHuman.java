package com.blade.practice.designpattern.factorymethod.multifactory;

/**
 * TODO:
 *
 * @author Blade
 * @date 2019/3/24 10:28
 */
public class WhiteHuman implements Human {
    @Override
    public void getColor() {
        System.out.println("i am white");
    }

    @Override
    public void talk() {
        System.out.println("i am speak english");
    }
}
