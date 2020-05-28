package com.blade.practice.designpattern.proxy.constraintproxy;

/**
 * TODO:
 *
 * @author Blade
 * @date 2019/4/12 9:30
 */
public class FGamePlayerProxy implements IFGamePlayer {
    private IFGamePlayer gamePlayer = null;

    @Override
    public IFGamePlayer getProxy() {
        return this;
    }

    public FGamePlayerProxy(IFGamePlayer gamePlayer) {
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
