package com.blade.practice.designpattern.observer.classdiagramexample;

/**
 * TODO:
 *
 * @author Blade
 * @date 2019/3/29 8:49
 */
public class HanFeiZi implements IHanFeiZi {

    private boolean isHaveBreakfast = false;
    private boolean isHaveFun = false;

    @Override
    public void haveBreakfast() {
        System.out.println("han fei zi have breakfast now");
        this.isHaveBreakfast = true;
    }

    @Override
    public void haveFun() {
        System.out.println("han fei zi have fun now");
        this.isHaveFun = true;
    }

    public boolean isHaveBreakfast() {
        return isHaveBreakfast;
    }

    public void setHaveBreakfast(boolean haveBreakfast) {
        isHaveBreakfast = haveBreakfast;
    }

    public boolean isHaveFun() {
        return isHaveFun;
    }

    public void setHaveFun(boolean haveFun) {
        isHaveFun = haveFun;
    }
}
