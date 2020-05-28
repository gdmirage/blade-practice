package com.blade.practice.designpattern.factorymethod.simplefactory;

import com.blade.practice.designpattern.factorymethod.classdiagramexample.BlackHuman;
import com.blade.practice.designpattern.factorymethod.classdiagramexample.WhiteHuman;
import com.blade.practice.designpattern.factorymethod.classdiagramexample.YellowHuman;

/**
 * TODO:
 *
 * @author Blade
 * @date 2019/3/24 10:16
 */
public class SimpleFactoryNvWa {

    public static void createHuman() {
        YellowHuman yellowHuman = HumanFactory.createHuman(YellowHuman.class);
        yellowHuman.getColor();
        yellowHuman.talk();
        System.out.println("-------");
        System.out.println("-------");

        WhiteHuman whiteHuman = HumanFactory.createHuman(WhiteHuman.class);
        whiteHuman.getColor();
        whiteHuman.talk();
        System.out.println("-------");
        System.out.println("-------");

        BlackHuman blackHuman = HumanFactory.createHuman(BlackHuman.class);
        blackHuman.getColor();
        blackHuman.talk();
    }
}
