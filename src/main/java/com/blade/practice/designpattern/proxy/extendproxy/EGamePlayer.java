package com.blade.practice.designpattern.proxy.extendproxy;

/**
 * TODO:
 *
 * @author Blade
 * @date 2019/4/11 22:52
 */
public class EGamePlayer implements IEGamePlayer {

    private String name = "";

    public EGamePlayer(String name) {
        this.name = name;
    }

    @Override
    public void login(String user, String password) {
        System.out.println(String.format("登录名为%s的用户%s登录成功！", user, this.name));
    }

    @Override
    public void killBoss() {
        System.out.println(String.format("%s在打怪", this.name));
    }

    @Override
    public void upgrade() {
        System.out.println(String.format("%s又升了一级", this.name));
    }
}
