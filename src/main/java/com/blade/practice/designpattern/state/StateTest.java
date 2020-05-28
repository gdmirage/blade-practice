package com.blade.practice.designpattern.state;

import com.blade.practice.designpattern.state.classdiagramexample.ConcreteState1;
import com.blade.practice.designpattern.state.classdiagramexample.Context;

public class StateTest {

    public static void main(String[] args) {
        classDiagramExampleTest();
    }

    private static void classDiagramExampleTest() {
        Context context = new Context();

        context.setCurrentState(new ConcreteState1());

        context.handle1();
        context.handle2();
    }
}
