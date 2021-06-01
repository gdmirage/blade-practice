package com.blade.practice.project.connect;

import com.blade.practice.project.codec.Packet;
import io.netty.channel.Channel;

/**
 * TODO:
 *
 * @author blade
 * 2021/5/29 11:09
 */
public class Connection {

    private Channel channel;

    private SessionContext sessionContext;

    private boolean security;

    public SessionContext getSessionContext() {
        return sessionContext;
    }

    public void setSessionContext(SessionContext sessionContext) {
        this.sessionContext = sessionContext;
    }

    public Channel getChannel(){
        return this.channel;
    }

    public void close(){

    }

    public boolean isConnected() {
        return true;
    }
    public boolean isReadTimeout() {
        return true;
    }

    public void init(Channel channel, boolean security){
        this.channel = channel;
        this.security = security;
    }

    public void send(Packet packet) {

    }
}
