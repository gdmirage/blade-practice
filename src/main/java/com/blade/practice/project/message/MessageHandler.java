package com.blade.practice.project.message;

import com.blade.practice.project.codec.Packet;
import com.blade.practice.project.connect.Connection;

/**
 * TODO:
 *
 * @author blade
 * 2021/5/30 15:42
 */
public interface MessageHandler {

    void handle(Packet packet, Connection connection);
}
