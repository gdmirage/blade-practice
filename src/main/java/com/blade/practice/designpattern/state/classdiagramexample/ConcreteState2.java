package com.blade.practice.designpattern.state.classdiagramexample;

public class ConcreteState2 extends State {
    @Override
    public void handle1() {
        // 设置当前状态为state1
        super.context.setCurrentState(Context.STATE1);
        // 过渡到state2状态，有context实现
        super.context.handle1();
    }

    @Override
    public void handle2() {
        // 本状态下必须处理的逻辑
        System.out.println("state 2 something");
    }
}
