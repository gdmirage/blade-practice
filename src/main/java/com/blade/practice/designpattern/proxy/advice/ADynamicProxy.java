package com.blade.practice.designpattern.proxy.advice;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * TODO:
 *
 * @author Blade
 * @date 2019/4/12 11:52
 */
public class ADynamicProxy<T> {

    public static <T> T newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler handler) {
        if (true) {
            // 执行一个前置通知
            (new ABeforeAdvice()).exec();
        }
        return (T) Proxy.newProxyInstance(loader, interfaces, handler);
    }
}
