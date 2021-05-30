package com.blade.practice.project.codec;

/**
 * TODO:
 *
 * @author blade
 * 2021/5/30 15:46
 */
public class Packet {

    public String body;

    public byte cmd;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public byte getCmd() {
        return cmd;
    }

    public void setCmd(byte cmd) {
        this.cmd = cmd;
    }
}
