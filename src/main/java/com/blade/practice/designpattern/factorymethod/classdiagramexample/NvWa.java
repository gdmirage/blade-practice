package com.blade.practice.designpattern.factorymethod.classdiagramexample;

/**
 * TODO:
 *
 * @author Blade
 * @date 2019/3/24 10:16
 */
public class NvWa {

    public static void createHuman() {
        HumanFactory humanFactory = new HumanFactory();

        YellowHuman yellowHuman = humanFactory.createHuman(YellowHuman.class);
        yellowHuman.getColor();
        yellowHuman.talk();
        System.out.println("-------");
        System.out.println("-------");

        WhiteHuman whiteHuman = humanFactory.createHuman(WhiteHuman.class);
        whiteHuman.getColor();
        whiteHuman.talk();
        System.out.println("-------");
        System.out.println("-------");

        BlackHuman blackHuman = humanFactory.createHuman(BlackHuman.class);
        blackHuman.getColor();
        blackHuman.talk();
    }
}
