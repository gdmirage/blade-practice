package com.blade.practice.designpattern.factorymethod.classdiagramexample;

/**
 * TODO:
 *
 * @author Blade
 * @date 2019/3/24 10:27
 */
public class HumanFactory extends AbstractHumanFactory {
    @Override
    public <T extends Human> T createHuman(Class<T> clazz) {
        Human human = null;

        try {
            human = (T)Class.forName(clazz.getName()).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            System.out.println("create human error");
        }
        return (T)human;
    }
}
