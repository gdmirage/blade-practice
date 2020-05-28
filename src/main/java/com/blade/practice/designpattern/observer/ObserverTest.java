package com.blade.practice.designpattern.observer;

import com.blade.practice.designpattern.observer.classdiagram.ConcreteObserver1;
import com.blade.practice.designpattern.observer.classdiagram.ConcreteObserver2;
import com.blade.practice.designpattern.observer.classdiagram.ConcreteSubject;
import com.blade.practice.designpattern.observer.classdiagram.IObserver;
import com.blade.practice.designpattern.observer.classdiagramexample.HanFeiZi;
import com.blade.practice.designpattern.observer.classdiagramexample.LiSi;
import com.blade.practice.designpattern.observer.classdiagramexample.Spy;
import com.blade.practice.designpattern.observer.javautilobserver.IJHanFeiZi;
import com.blade.practice.designpattern.observer.javautilobserver.JHanFeiZi;
import com.blade.practice.designpattern.observer.javautilobserver.JLiSi;
import com.blade.practice.designpattern.observer.multiObserver.IMHanFeiZi;
import com.blade.practice.designpattern.observer.multiObserver.IMObserver;
import com.blade.practice.designpattern.observer.multiObserver.MHanFeiZi;
import com.blade.practice.designpattern.observer.multiObserver.MLiSi;
import com.blade.practice.designpattern.observer.multiObserver.MLiuSi;
import com.blade.practice.designpattern.observer.multiObserver.MWangSi;

/**
 * TODO:
 * 观察者模式测试方法
 * @author Blade
 * @date 2019/3/28 15:52
 */
public class ObserverTest {

    public static void main(String[] args) {
//        classDiagramTest();
//        classDiagramExampleTest();
//        multiObserverTest();
        javaUtilObserverTest();
    }

    /**
     * 观察者模式通用类图测试
     */
    private static void classDiagramTest() {
        ConcreteSubject subject = new ConcreteSubject();
        IObserver observer1 = new ConcreteObserver1();

        IObserver observer2 = new ConcreteObserver2();

        subject.addObserver(observer1);
        subject.addObserver(observer2);

        subject.doSomething();
    }

    private static void classDiagramExampleTest() {
        LiSi liSi = new LiSi();
        HanFeiZi hanFeiZi = new HanFeiZi();
        Spy watchBreakfast = new Spy(hanFeiZi, liSi, "breakfast");
        watchBreakfast.start();

        Spy watchFun = new Spy(hanFeiZi, liSi, "fun");
        watchFun.start();

        try {
            Thread.sleep(1000);
            hanFeiZi.haveBreakfast();
            Thread.sleep(1000);
            hanFeiZi.haveFun();
            System.out.println(hanFeiZi.isHaveBreakfast() + "----" + hanFeiZi.isHaveFun());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void multiObserverTest() {
        IMObserver liSi = new MLiSi();
        IMObserver wangSi = new MWangSi();
        IMObserver liuSi = new MLiuSi();

        MHanFeiZi hanFeiZi = new MHanFeiZi();

        hanFeiZi.addObserver(liSi);
        hanFeiZi.addObserver(wangSi);
        hanFeiZi.addObserver(liuSi);

        hanFeiZi.haveBreakfast();
    }

    private static void javaUtilObserverTest() {
        JHanFeiZi hanFeiZi = new JHanFeiZi();

        hanFeiZi.addObserver(new JLiSi());

        hanFeiZi.haveBreakfast();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        hanFeiZi.haveFun();
    }
}
