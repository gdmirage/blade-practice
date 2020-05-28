package com.blade.practice.designpattern.strategy.classdiagram;

/**
 * TODO:
 *
 * @author Blade
 * @date 2019/3/28 11:05
 */
public class Context {
    private Strategy strategy = null;

    public Context(Strategy _strategy) {
        this.strategy = _strategy;
    }

    /**
     * 封装后的策略方法
     */
    public void doAnything() {
        this.strategy.doSomething();
    }
}
