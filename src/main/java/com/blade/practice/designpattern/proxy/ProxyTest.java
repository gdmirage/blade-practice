package com.blade.practice.designpattern.proxy;

import com.blade.practice.designpattern.proxy.advice.ADynamicProxy;
import com.blade.practice.designpattern.proxy.advice.ARealSubject;
import com.blade.practice.designpattern.proxy.advice.ASubject;
import com.blade.practice.designpattern.proxy.advice.ASubjectDynamicProxy;
import com.blade.practice.designpattern.proxy.advice.MyInvocationHandler;
import com.blade.practice.designpattern.proxy.cglib.CgLibGamePlayer;
import com.blade.practice.designpattern.proxy.cglib.CgLibGamePlayerProxy;
import com.blade.practice.designpattern.proxy.cglibargs.ACgLibGamePlayer;
import com.blade.practice.designpattern.proxy.cglibargs.ACgLibGamePlayerProxy;
import com.blade.practice.designpattern.proxy.classdiagram.CProxy;
import com.blade.practice.designpattern.proxy.classdiagram.CRealSubject;
import com.blade.practice.designpattern.proxy.classdiagram.CSubject;
import com.blade.practice.designpattern.proxy.classdiagramexample.CGamePlayer;
import com.blade.practice.designpattern.proxy.classdiagramexample.CGamePlayerProxy;
import com.blade.practice.designpattern.proxy.classdiagramexample.ICGamePlayer;
import com.blade.practice.designpattern.proxy.constraintproxy.FGamePlayer;
import com.blade.practice.designpattern.proxy.constraintproxy.FGamePlayerProxy;
import com.blade.practice.designpattern.proxy.constraintproxy.IFGamePlayer;
import com.blade.practice.designpattern.proxy.dynamicproxy.GamePlayInvocationHandler;
import com.blade.practice.designpattern.proxy.extendproxy.EGamePlayer;
import com.blade.practice.designpattern.proxy.extendproxy.EGamePlayerProxy;
import com.blade.practice.designpattern.proxy.extendproxy.IEGamePlayer;
import com.blade.practice.designpattern.proxy.normalproxy.INGamePlayer;
import com.blade.practice.designpattern.proxy.normalproxy.NGamePlayerProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * TODO:
 *
 * @author Blade
 * @date 2019/4/11 16:24
 */
public class ProxyTest {

    public static void main(String[] args) {
//        classDiagramTest();
//        classDiagramExampleTest();
//        normalProxyTest();
//        constraintProxyTest1();
//        constraintProxyTest2();
//        constraintProxyTest3();
//        extendProxyTest();
//        dynamicProxyTest();
//        adviceTest();
//        adviceTest2();
//        cglibTest();
        cglibArgsTest();
    }

    /**
     * 代理模式通用类图例子
     */
    private static void classDiagramTest() {
        CSubject subject = new CProxy(new CRealSubject());

        subject.request();
    }

    /**
     * 通用类图：游戏代打的例子
     */
    private static void classDiagramExampleTest() {
        ICGamePlayer gamePlayer = new CGamePlayerProxy(new CGamePlayer("zhangsan"));

        gamePlayer.login("zhang san", "123456");
        gamePlayer.killBoss();
        gamePlayer.upgrade();
    }

    /**
     * 普通代理
     * 调用者只是知道了代理，而不用知道真实的角色是谁，屏蔽了真实角色对高层模块的影响
     * 该模式非常适合对扩展性要求较高的场合
     */
    private static void normalProxyTest() {
        INGamePlayer proxy = new NGamePlayerProxy("zhangsan");
        proxy.login("blade", "123");
        proxy.killBoss();
        proxy.upgrade();
    }

    /**
     * 强制代理测试方法1
     * 直接访问真实角色，禁止访问
     */
    private static void constraintProxyTest1() {
        IFGamePlayer gamePlayer = new FGamePlayer("zhangsan");
        gamePlayer.login("blade", "123");
        gamePlayer.killBoss();
        gamePlayer.upgrade();
    }

    /**
     * 强制代理测试方法1
     * 直接访问代理类，禁止访问
     */
    private static void constraintProxyTest2() {
        IFGamePlayer gamePlayer = new FGamePlayer("zhangsan");
        IFGamePlayer proxy = new FGamePlayerProxy(gamePlayer);
        gamePlayer.login("blade", "123");
        gamePlayer.killBoss();
        gamePlayer.upgrade();
    }

    /**
     * 强制代理测试方法1
     * 从真实角色找到代理角色
     */
    private static void constraintProxyTest3() {
        IFGamePlayer gamePlayer = new FGamePlayer("zhangsan");
        // 获得指定代理
        IFGamePlayer proxy = gamePlayer.getProxy();
        gamePlayer.login("blade", "123");
        gamePlayer.killBoss();
        gamePlayer.upgrade();
    }

    /**
     * 增加额外功能的静态代理
     * 可以实现多接口，增加不同的业务
     */
    private static void extendProxyTest() {
        IEGamePlayer gamePlayer = new EGamePlayer("zhangsan");
        IEGamePlayer proxy = new EGamePlayerProxy(gamePlayer);

        proxy.login("blade", "123");
        proxy.killBoss();
        proxy.upgrade();
    }

    private static void dynamicProxyTest() {
        ICGamePlayer gamePlayer = new CGamePlayer("zhangsan");
        InvocationHandler handler = new GamePlayInvocationHandler(gamePlayer);

        ClassLoader cl = gamePlayer.getClass().getClassLoader();
        ICGamePlayer proxy = (ICGamePlayer) Proxy.newProxyInstance(cl, new Class[]{ICGamePlayer.class}, handler);

        proxy.login("blade", "123");
        proxy.killBoss();
        proxy.upgrade();
    }

    /**
     * 动态代理测试
     */
    private static void adviceTest() {
        ASubject subject = new ARealSubject();

        InvocationHandler handler = new MyInvocationHandler(subject);

        ASubject proxy = ADynamicProxy.newProxyInstance(subject.getClass().getClassLoader(),
                subject.getClass().getInterfaces(), handler);

        proxy.doSomething("lala");
    }

    /**
     * 基于adviceTest 这个方法，扩展出 ASubjectDynamicProxy 这个类
     */
    private static void adviceTest2() {
        ASubject subject = new ARealSubject();

        InvocationHandler handler = new MyInvocationHandler(subject);

        ASubject proxy = ASubjectDynamicProxy.newProxyInstance(subject);

        proxy.doSomething("lala");
    }

    /**
     * cglib 动态代理 构造函数不带参数的例子
     */
    private static void cglibTest() {
        CgLibGamePlayerProxy proxy = new CgLibGamePlayerProxy();

        CgLibGamePlayer player = (CgLibGamePlayer) proxy.newProxyInstance(new CgLibGamePlayer());
        player.killBoss();
    }

    /**
     * 带参数的cglib 动态代理
     */
    private static void cglibArgsTest() {
        ACgLibGamePlayerProxy proxy = new ACgLibGamePlayerProxy();

        ACgLibGamePlayer player = proxy.newProxyInstance(new ACgLibGamePlayer(), new Class[]{String.class}, new Object[]{"blade"});

        player.login("lala", "123");
    }
}
