package com.blade.practice.designpattern.proxy.normalproxy;

/**
 * TODO:
 *
 * @author Blade
 * @date 2019/4/12 9:02
 */
public class NGamePlayer implements INGamePlayer {

    private String name = "";

    public NGamePlayer(INGamePlayer gamePlayer, String name) throws Exception{
        if (null == gamePlayer) {
            throw new Exception("");
        }else {
            this.name = name;
        }
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
