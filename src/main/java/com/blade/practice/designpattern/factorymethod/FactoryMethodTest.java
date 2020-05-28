package com.blade.practice.designpattern.factorymethod;

import com.blade.practice.designpattern.factorymethod.classdiagram.ConcreteCreator;
import com.blade.practice.designpattern.factorymethod.classdiagram.Product1;
import com.blade.practice.designpattern.factorymethod.classdiagram.Product2;
import com.blade.practice.designpattern.factorymethod.classdiagramexample.NvWa;
import com.blade.practice.designpattern.factorymethod.multifactory.MultiFacotryNvWa;
import com.blade.practice.designpattern.factorymethod.simplefactory.SimpleFactoryNvWa;

/**
 * TODO:
 * 工厂方法模式测试。代码参考《设计模式之禅》
 * @author Blade
 * @date 2019/3/24 0:25
 */
public class FactoryMethodTest {

    public static void main(String[] args) {
//        classDiagramTest();
//        classDiagramExampleTest();
//        simpleFactoryTest();
        multiFactoryTest();
    }

    /**
     * 工厂模式通用类图的组成方法
     */
    private static void classDiagramTest() {
        ConcreteCreator creator = new ConcreteCreator();
        Product1 product1 = creator.createProduct(Product1.class);

        product1.method1();

        Product2 product2 = creator.createProduct(Product2.class);
        product2.method1();
    }

    /**
     * 女娲造人的例子，阐述工厂方法模式
     */
    private static void classDiagramExampleTest() {
        NvWa.createHuman();
    }

    /**
     * 根据女娲造人的例子，阐述简单工厂
     */
    private static void simpleFactoryTest() {
        SimpleFactoryNvWa.createHuman();
    }

    /**
     * 根据女娲造人的例子，变成多个工厂
     */
    private static void multiFactoryTest() {
        MultiFacotryNvWa.createHuman();
    }
}
