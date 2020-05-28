package com.blade.practice.designpattern.proxy.classdiagramexample;

/**
 * TODO:
 *
 * @author Blade
 * @date 2019/4/11 22:55
 */
public class CGamePlayerProxy implements ICGamePlayer {

    private ICGamePlayer gamePlayer = null;

    public CGamePlayerProxy(ICGamePlayer gamePlayer) {
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
    }
}
