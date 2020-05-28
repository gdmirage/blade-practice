package com.blade.practice.designpattern.adapter.classdiagram;

/**
 * TODO:
 * 源角色 : 它是一个已经存在的、运行良好的类或对象，经过适配器角色的包装， 它会成为一个崭新、靓丽的角色
 * @author Blade
 * @date 2019/3/24 23:05
 */
public class Adaptee {

    public void doSomething() {
        System.out.println("i am adaptee, la la la!");
    }

}
