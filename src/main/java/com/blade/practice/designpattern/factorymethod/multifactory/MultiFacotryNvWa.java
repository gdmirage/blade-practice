package com.blade.practice.designpattern.factorymethod.multifactory;

/**
 * TODO:
 *
 * @author Blade
 * @date 2019/3/24 10:16
 */
public class MultiFacotryNvWa {

    public static void createHuman() {
        YellowHuman yellowHuman = (YellowHuman) (new YellowHumanFactory()).createHuman();
        yellowHuman.getColor();
        yellowHuman.talk();
        System.out.println("-------");
        System.out.println("-------");

        WhiteHuman whiteHuman = (WhiteHuman) (new WhiteHumanFactory()).createHuman();
        whiteHuman.getColor();
        whiteHuman.talk();
        System.out.println("-------");
        System.out.println("-------");

        BlackHuman blackHuman = (BlackHuman) (new BlackHumanFactory()).createHuman();
        blackHuman.getColor();
        blackHuman.talk();
    }
}
