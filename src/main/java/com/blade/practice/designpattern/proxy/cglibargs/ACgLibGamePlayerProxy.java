package com.blade.practice.designpattern.proxy.cglibargs;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * TODO:
 *
 * @author Blade
 * @date 2019/4/12 22:27
 */
public class ACgLibGamePlayerProxy implements MethodInterceptor {

    /**
     * 创建代理对象方法
     *
     * @param target    代理对象
     * @param argsTypes 对应的构造器参数类型
     *                  <p>
     *                  例：有构造器如下
     *                  public Person(name,age){...} name为String.class age为int.class
     *                  写入name的类型与age的类型
     *                  <p>
     *                  则：new Class[]{String.class,int.class}
     * @param argsValue 对应的构造器参数值
     *                  <p>
     *                  例:如此创建对象 new Person("name",23) 用以下方式传入：new Object[]{"name",23}
     * @param <T>       <泛型方法>
     * @return 返回跟代理对象类型
     */
    public <T> T newProxyInstance(T target, Class[] argsTypes, Object[] argsValue) {
        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);

        return (T) enhancer.create(argsTypes, argsValue);
    }

    /**
     * 创建代理对象方法
     *
     * @param target 代理对象
     * @param <T>    <泛型方法>
     * @return 返回跟代理对象类型
     */
    public <T> T newProxyInstance(T target) {
        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);

        return (T) enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("i am proxy, what do you want to do before exec method");
        methodProxy.invokeSuper(o, objects);
        System.out.println("i am proxy, what do you want to do after exec method");
        return null;
    }
}
