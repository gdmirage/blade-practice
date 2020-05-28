package com.blade.practice.designpattern.strategy.extend;

/**
 * TODO:
 *
 * @author Blade
 * @date 2019/3/28 13:48
 */
public class NormalCalculator {

    private final static String ADD_SYMBOL = "+";
    private final static String SUB_SYMBOL = "-";

    public int exec(int a, int b, String symbol) {
        return symbol.equals(ADD_SYMBOL) ? (a + b) : (a - b);
    }
}
