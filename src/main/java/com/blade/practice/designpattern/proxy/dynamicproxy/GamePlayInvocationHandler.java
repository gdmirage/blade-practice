package com.blade.practice.designpattern.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * TODO:
 *
 * @author Blade
 * @date 2019/4/12 11:26
 */
public class GamePlayInvocationHandler implements InvocationHandler {
    /**
     * 被代理者
     */
    Class clazz = null;

    /**
     * 被代理的实例
     */
    Object obj = null;

    /**
     * 我要代理谁
     * @param obj
     */
    public GamePlayInvocationHandler(Object obj) {
        this.obj = obj;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(this.obj, args);

        if(method.getName().equalsIgnoreCase("login")) {
            System.out.println("有人在用我的账号登录");
        }

        return result;
    }
}
