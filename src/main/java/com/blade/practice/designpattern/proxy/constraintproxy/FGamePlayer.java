package com.blade.practice.designpattern.proxy.constraintproxy;

/**
 * TODO:
 *
 * @author Blade
 * @date 2019/4/12 9:02
 */
public class FGamePlayer implements IFGamePlayer {

    private String name = "";

    private IFGamePlayer proxy = null;

    public FGamePlayer(String name) {
        this.name = name;
    }

    @Override
    public void login(String user, String password) {
        if (isProxy()) {
            System.out.println(String.format("登录名为%s的用户%s登录成功！", user, this.name));
        } else {
            System.out.println("请使用指定的代理访问");
        }
    }

    @Override
    public void killBoss() {
        if (isProxy()) {
            System.out.println(String.format("%s在打怪", this.name));
        } else {
            System.out.println("请使用指定的代理访问");
        }
    }

    @Override
    public void upgrade() {
        if (isProxy()) {
            System.out.println(String.format("%s又升了一级", this.name));
        } else {
            System.out.println("请使用指定的代理访问");
        }
    }

    @Override
    public IFGamePlayer getProxy() {
        this.proxy = new FGamePlayerProxy(this);
        return this.proxy;
    }

    private boolean isProxy() {
        return (null != this.proxy);
    }
}
