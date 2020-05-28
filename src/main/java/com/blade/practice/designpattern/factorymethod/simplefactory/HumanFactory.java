package com.blade.practice.designpattern.factorymethod.simplefactory;

import com.blade.practice.designpattern.factorymethod.classdiagramexample.Human;

/**
 * TODO:
 * 简单工厂
 * @author Blade
 * @date 2019/3/24 11:52
 */
public class HumanFactory {
    public static <T extends Human> T createHuman(Class<T> clazz) {
        Human human = null;

        try {
            System.out.println("simple factory create human");
            human = (T)Class.forName(clazz.getName()).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return (T) human;
    }
}
