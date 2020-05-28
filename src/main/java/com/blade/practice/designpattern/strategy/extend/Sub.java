package com.blade.practice.designpattern.strategy.extend;

/**
 * TODO:
 *
 * @author Blade
 * @date 2019/3/28 14:11
 */
public class Sub implements IStrategyCalculator {
    @Override
    public int exec(int a, int b) {
        return a - b;
    }
}
