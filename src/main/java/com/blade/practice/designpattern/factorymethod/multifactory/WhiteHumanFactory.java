package com.blade.practice.designpattern.factorymethod.multifactory;

/**
 * TODO:
 *
 * @author Blade
 * @date 2019/3/24 10:27
 */
public class WhiteHumanFactory extends AbstractHumanFactory {
    @Override
    public Human createHuman() {
        System.out.println("white human factory create human");
        return new WhiteHuman();
    }
}
