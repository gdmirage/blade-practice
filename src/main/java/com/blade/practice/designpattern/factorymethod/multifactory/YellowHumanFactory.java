package com.blade.practice.designpattern.factorymethod.multifactory;

/**
 * TODO:
 *
 * @author Blade
 * @date 2019/3/24 12:06
 */
public class YellowHumanFactory extends AbstractHumanFactory {
    @Override
    public Human createHuman() {
        System.out.println("yellow human factory create human");
        return new YellowHuman();
    }
}
