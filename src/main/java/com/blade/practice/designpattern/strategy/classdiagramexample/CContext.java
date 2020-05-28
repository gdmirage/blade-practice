package com.blade.practice.designpattern.strategy.classdiagramexample;

/**
 * TODO:
 * 刘备娶亲
 * @author Blade
 * @date 2019/3/28 11:13
 */
public class CContext {
    private ICStrategy icStrategy = null;

    public CContext(ICStrategy icStrategy){
        this.icStrategy = icStrategy;
    }

    public void operate() {
        this.icStrategy.operate();
    }
}
