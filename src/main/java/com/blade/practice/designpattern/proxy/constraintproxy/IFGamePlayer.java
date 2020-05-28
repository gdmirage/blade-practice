package com.blade.practice.designpattern.proxy.constraintproxy;

/**
 * TODO:
 *
 * @author Blade
 * @date 2019/4/12 9:02
 */
public interface IFGamePlayer {

    void login(String user, String password);

    void killBoss();

    void upgrade();

    IFGamePlayer getProxy();
}
