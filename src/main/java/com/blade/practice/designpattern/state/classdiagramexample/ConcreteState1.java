package com.blade.practice.designpattern.state.classdiagramexample;

public class ConcreteState1 extends State {
    @Override
    public void handle1() {
        // 本状态下必须处理的逻辑
        System.out.println("state 1 something");
    }

    @Override
    public void handle2() {
        // 设置当前状态为state2
        super.context.setCurrentState(Context.STATE2);
        // 过渡到state2状态，有context实现
        super.context.handle2();
    }
}
