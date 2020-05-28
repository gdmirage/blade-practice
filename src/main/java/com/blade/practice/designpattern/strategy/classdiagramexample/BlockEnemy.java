package com.blade.practice.designpattern.strategy.classdiagramexample;

/**
 * TODO:
 *
 * @author Blade
 * @date 2019/3/28 11:12
 */
public class BlockEnemy implements ICStrategy {
    @Override
    public void operate() {
        System.out.println("第三个锦囊:孙夫人断后");
    }
}
