package com.blade.practice.designpattern.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * TODO:
 *
 * @author Blade
 * @date 2019/4/12 17:33
 */
public class CgLibGamePlayerProxy implements MethodInterceptor {

    public Object newProxyInstance(Object target) {
        Enhancer enhancer = new Enhancer();

        Class clazz = target.getClass();

        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);

        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        methodProxy.invokeSuper(o, objects);
        return null;
    }
}
