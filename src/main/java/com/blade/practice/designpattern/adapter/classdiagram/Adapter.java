package com.blade.practice.designpattern.adapter.classdiagram;

/**
 * TODO:
 * 适配器角色: 适配器模式的核心角色，其他两个角色都是已经存在的角色，而适配器角色是需要新建立的。
 * 它的职责非常简单: 把源角色转换为目标角色。通过继承或者类关联的方式
 * @author Blade
 * @date 2019/3/24 23:07
 */
public class Adapter extends Adaptee implements Target {
    @Override
    public void request() {
        super.doSomething();
    }
}
