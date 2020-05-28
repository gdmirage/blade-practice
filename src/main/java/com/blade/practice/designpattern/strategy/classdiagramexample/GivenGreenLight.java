package com.blade.practice.designpattern.strategy.classdiagramexample;

/**
 * TODO:
 *
 * @author Blade
 * @date 2019/3/28 11:12
 */
public class GivenGreenLight implements ICStrategy {
    @Override
    public void operate() {
        System.out.println("第二个锦囊:找吴国太开绿灯");
    }
}
