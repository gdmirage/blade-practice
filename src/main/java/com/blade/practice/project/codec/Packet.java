package com.blade.practice.project.codec;

/**
 * TODO:
 *
 * @author blade
 * 2021/5/30 15:46
 */
public class Packet {

    public String body;

    /**
     * 表示消息协议类型
     */
    public byte cmd;

    /**
     * 表示body的长度
     */
    public int length;

    /**
     * 根据body生成的一个校验码
     */
    public short checkcode;

    /**
     * 表示当前包启用的特性，比如是否启用加密，是否启用压缩
     */
    public byte flags;

    /**
     * 消息会话标识，用于消息响应
     */
    public int sessionId;

    /**
     * 纵向冗余校验字段，校验header
     */
    public byte lrc;

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
