package com.blade.practice.designpattern.proxy.cglibargs;

/**
 * TODO:
 *
 * @author Blade
 * @date 2019/4/12 22:29
 */
public class ACgLibGamePlayer {

    private String name;

    public ACgLibGamePlayer(String name) {
        this.name = name;
    }

    public ACgLibGamePlayer(){}

    public void login(String user, String password) {
        System.out.println(String.format("登录名为%s的用户%s登录成功！", user, this.name));
    }

    public void killBoss() {
        System.out.println(String.format("%s在打怪", this.name));
    }

    public void upgrade() {
        System.out.println(String.format("%s又升了一级", this.name));
    }
}
