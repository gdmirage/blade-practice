package com.blade.practice.designpattern.proxy.cglib;

/**
 * TODO:
 *
 * @author Blade
 * @date 2019/4/12 17:31
 */
public class CgLibGamePlayer {

    private String user;

    public void login(String user, String password) {
        this.user = user;
        System.out.println(String.format("用户%s登录成功！", user));
    }

    public void killBoss() {
        System.out.println(String.format("%s在打怪", this.user));
    }

    public void upgrade() {
        System.out.println(String.format("%s又升了一级", this.user));
    }
}
