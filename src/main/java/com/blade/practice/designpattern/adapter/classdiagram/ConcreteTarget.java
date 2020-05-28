package com.blade.practice.designpattern.adapter.classdiagram;

/**
 * TODO:
 * 目标角色，已经是正在运行的角色，不能改变代码
 * @author Blade
 * @date 2019/3/24 23:09
 */
public class ConcreteTarget implements Target{
    @Override
    public void request() {
        System.out.println("i am concrete target。 can not change my code");
    }
}
