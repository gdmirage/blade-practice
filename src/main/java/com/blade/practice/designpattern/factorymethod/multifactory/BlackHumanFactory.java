package com.blade.practice.designpattern.factorymethod.multifactory;

/**
 * TODO:
 *
 * @author Blade
 * @date 2019/3/24 12:05
 */
public class BlackHumanFactory extends AbstractHumanFactory {
    @Override
    public Human createHuman() {
        System.out.println("black human factory create human");
        return new BlackHuman();
    }
}
