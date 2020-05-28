package com.blade.practice.designpattern.factorymethod.classdiagram;

/**
 * TODO:
 *
 * @author Blade
 * @date 2019/3/24 0:17
 */
public abstract class AbstractCreator {

    public abstract <T extends AbstractProduct> T createProduct(Class<T> clazz);
}
