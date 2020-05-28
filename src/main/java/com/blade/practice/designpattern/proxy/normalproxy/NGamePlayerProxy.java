package com.blade.practice.designpattern.proxy.normalproxy;

/**
 * TODO:
 *
 * @author Blade
 * @date 2019/4/12 9:30
 */
public class NGamePlayerProxy implements INGamePlayer {
    private INGamePlayer gamePlayer = null;

    public NGamePlayerProxy(String user) {
        try {
            gamePlayer = new NGamePlayer(this, user);
        } catch (Exception e) {
            // 异常
        }
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
