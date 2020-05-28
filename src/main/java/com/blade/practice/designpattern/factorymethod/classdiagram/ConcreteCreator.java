package com.blade.practice.designpattern.factorymethod.classdiagram;

/**
 * TODO:
 *
 * @author Blade
 * @date 2019/3/24 0:19
 */
public class ConcreteCreator extends AbstractCreator {
    @Override
    public <T extends AbstractProduct> T createProduct(Class<T> clazz) {

        AbstractProduct product = null;

        try {
            product = (AbstractProduct) Class.forName(clazz.getName()).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return (T)product;
    }
}
