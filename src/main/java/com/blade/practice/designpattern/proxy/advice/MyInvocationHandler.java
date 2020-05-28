package com.blade.practice.designpattern.proxy.advice;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * TODO:
 *
 * @author Blade
 * @date 2019/4/12 11:50
 */
public class MyInvocationHandler implements InvocationHandler {

    private Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(this.target, args);
    }
}
