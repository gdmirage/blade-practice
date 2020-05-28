package com.blade.practice.designpattern.proxy.advice;

import java.lang.reflect.InvocationHandler;

/**
 * TODO:
 *
 * @author Blade
 * @date 2019/4/12 15:35
 */
public class ASubjectDynamicProxy extends ADynamicProxy {

    public static <T> T newProxyInstance(ASubject subject) {
        ClassLoader loader = subject.getClass().getClassLoader();
        Class<?>[] classes = subject.getClass().getInterfaces();
        InvocationHandler handler = new MyInvocationHandler(subject);

        return newProxyInstance(loader, classes, handler);
    }
}
