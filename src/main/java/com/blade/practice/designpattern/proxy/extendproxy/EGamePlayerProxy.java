package com.blade.practice.designpattern.proxy.extendproxy;

/**
 * TODO:
 *
 * @author Blade
 * @date 2019/4/11 22:55
 */
public class EGamePlayerProxy implements IEGamePlayer {

    private IEGamePlayer gamePlayer = null;

    public EGamePlayerProxy(IEGamePlayer gamePlayer) {
        this.gamePlayer = gamePlayer;
    }

    @Override
    public void login(String user, String password) {
        this.gamePlayer.login(user, password);
    }

    @Override
    public void killBoss() {
        this.gamePlayer.killBoss();
    }

    @Override
    public void upgrade() {
        this.gamePlayer.upgrade();
        this.count();
    }

    private void count() {
        System.out.println("收费150");
    }
}
