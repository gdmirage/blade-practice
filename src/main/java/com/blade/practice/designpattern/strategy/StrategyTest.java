package com.blade.practice.designpattern.strategy;

import com.blade.practice.designpattern.strategy.classdiagram.ConcreteStrategy1;
import com.blade.practice.designpattern.strategy.classdiagram.ConcreteStrategy2;
import com.blade.practice.designpattern.strategy.classdiagram.Context;
import com.blade.practice.designpattern.strategy.classdiagramexample.BackDoor;
import com.blade.practice.designpattern.strategy.classdiagramexample.BlockEnemy;
import com.blade.practice.designpattern.strategy.classdiagramexample.CContext;
import com.blade.practice.designpattern.strategy.classdiagramexample.GivenGreenLight;
import com.blade.practice.designpattern.strategy.extend.Add;
import com.blade.practice.designpattern.strategy.extend.EnumCalculator;
import com.blade.practice.designpattern.strategy.extend.NormalCalculator;
import com.blade.practice.designpattern.strategy.extend.SimpleCalculator;
import com.blade.practice.designpattern.strategy.extend.StrategyCalculatorContext;
import com.blade.practice.designpattern.strategy.extend.Sub;

import java.util.Arrays;

/**
 * TODO:
 *
 * @author Blade
 * @date 2019/3/28 10:53
 */
public class StrategyTest {

    private final static String ADD_SYMBOL = "+";
    private final static String SUB_SYMBOL = "-";

    public static void main(String[] args) {
//        classDiagramTest();
//        classDiagramExampleTest();
//        normalCalculatorTest(args);
//        simpleCalculatorTest(args);
//        strategyCalculatorTest(args);
        enumCalculatorTest(args);
    }

    private static void classDiagramTest() {
        Context context = new Context(new ConcreteStrategy1());
        context.doAnything();

        Context context2 = new Context(new ConcreteStrategy2());
        context2.doAnything();
    }

    /**
     * 刘备要取孙尚香，赵云带着诸葛亮给的3个锦囊去江东
     */
    private static void classDiagramExampleTest() {
        CContext cContext = new CContext(new BackDoor());
        cContext.operate();

        CContext cContext1 = new CContext(new GivenGreenLight());
        cContext1.operate();

        CContext cContext2 = new CContext(new BlockEnemy());
        cContext2.operate();
    }

    /**
     * 正常的计算器
     * @param args
     */
    private static void normalCalculatorTest(String[] args) {
        int a = Integer.parseInt(args[0]);
        String symbol = args[1];
        int b = Integer.parseInt(args[2]);

        System.out.println("输入的参数为: " + Arrays.toString(args));

        NormalCalculator calculator = new NormalCalculator();

        System.out.println("运行结果为: " + a + symbol + b + "=" + calculator.exec(a, b, symbol));
    }

    /**
     * 简化代码后的计算器
     * @param args
     */
    private static void simpleCalculatorTest(String[] args) {
        int a = Integer.parseInt(args[0]);
        String symbol = args[1];
        int b = Integer.parseInt(args[2]);

        System.out.println("输入的参数为: " + Arrays.toString(args));

        SimpleCalculator calculator = new SimpleCalculator();

        System.out.println("运行结果为: " + a + symbol + b + "=" + calculator.exec(a, b, symbol));
    }

    /**
     * 使用策略模式的计算器
     * @param args
     */
    private static void strategyCalculatorTest(String[] args) {
        int a = Integer.parseInt(args[0]);
        String symbol = args[1];
        int b = Integer.parseInt(args[2]);

        System.out.println("输入的参数为: " + Arrays.toString(args));

        StrategyCalculatorContext context = null;

        if (symbol.equals(ADD_SYMBOL)) {
            context = new StrategyCalculatorContext(new Add());
        }else if (symbol.equals(SUB_SYMBOL)) {
            context = new StrategyCalculatorContext(new Sub());
        }

        System.out.println("运行结果为: " + a + symbol + b + "=" + context.exec(a, b, symbol));
    }

    /**
     * 策略枚举实现的计算器
     * @param args
     */
    private static void enumCalculatorTest(String[] args) {
        int a = Integer.parseInt(args[0]);
        String symbol = args[1];
        int b = Integer.parseInt(args[2]);

        System.out.println("输入的参数为: " + Arrays.toString(args));

        if (symbol.equals(ADD_SYMBOL)) {
            System.out.println("运行结果为: " + a + symbol + b + "=" + EnumCalculator.ADD.exec(a, b));
        }else if (symbol.equals(SUB_SYMBOL)) {
            System.out.println("运行结果为: " + a + symbol + b + "=" + EnumCalculator.SUB.exec(a, b));
        }

    }
}
