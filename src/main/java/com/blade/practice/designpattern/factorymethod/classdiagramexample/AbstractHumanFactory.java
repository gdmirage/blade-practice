package com.blade.practice.designpattern.factorymethod.classdiagramexample;

/**
 * TODO:
 *
 * @author Blade
 * @date 2019/3/24 10:17
 */
public abstract class AbstractHumanFactory {

     public abstract <T extends Human> T createHuman(Class<T> clazz);
}
