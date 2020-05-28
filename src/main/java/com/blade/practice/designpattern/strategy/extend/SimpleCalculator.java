package com.blade.practice.designpattern.strategy.extend;

/**
 * TODO:
 *
 * @author Blade
 * @date 2019/3/28 13:48
 */
public class SimpleCalculator {

    private final static String ADD_SYMBOL = "+";
    private final static String SUB_SYMBOL = "-";

    public int exec(int a, int b, String symbol) {
        int result = 0;

        if (symbol.equals(ADD_SYMBOL)) {
            return this.add(a, b);
        }else if (symbol.equals(SUB_SYMBOL)) {
            return this.sub(a, b);
        }

        return result;
    }

    private int add(int a, int b) {
        return a + b;
    }

    private int sub(int a, int b) {
        return a - b;
    }
}
