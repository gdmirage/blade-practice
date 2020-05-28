package com.blade.practice.designpattern.strategy.extend;

/**
 * TODO:
 *
 * @author Blade
 * @date 2019/3/28 14:12
 */
public class StrategyCalculatorContext {

    private IStrategyCalculator strategyCalculator = null;

    public StrategyCalculatorContext(IStrategyCalculator strategyCalculator) {
        this.strategyCalculator = strategyCalculator;
    }

    public int exec(int a, int b, String symbol) {
        return this.strategyCalculator.exec(a, b);
    }
}
