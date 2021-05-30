package com.blade.practice.project.message;

import com.blade.practice.project.codec.Packet;
import com.blade.practice.project.connect.Connection;
import com.blade.practice.project.protocol.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.function.Supplier;

/**
 * TODO:
 *
 * @author blade
 * 2021/5/30 10:00
 */
public class MessageDispatcher {

    private final static Logger LOGGER = LoggerFactory.getLogger(MessageDispatcher.class);

    public static final int POLICY_IGNORE = 0;

    private final int unsupportedPolicy;

    private static final HashMap<Byte, MessageHandler> handlers = new HashMap<>();

    public MessageDispatcher() {
        this.unsupportedPolicy = POLICY_IGNORE;
    }

    public MessageDispatcher(int unsupportedPolicy) {
        this.unsupportedPolicy = unsupportedPolicy;
    }

    public void register(Command command, MessageHandler handler){
        handlers.put(command.cmd, handler);
    }

    public void register(Command command, Supplier<MessageHandler> handlerSupplier, boolean enabled) {
        if (enabled && !handlers.containsKey(command.cmd)) {
            register(command, handlerSupplier.get());
        }
    }

    public void register(Command command, Supplier<MessageHandler> handlerSupplier){
        this.register(command, handlerSupplier, true);
    }

    public MessageHandler unRegister(Command command) {
        return handlers.remove(command.cmd);
    }

    public void onReceive(Packet packet, Connection connection) {
        MessageHandler handler = handlers.get(packet.cmd);
        if (null != handler) {
            LOGGER.info("time cost on [dispatch]");
            try {
                handler.handle(packet, connection);
            } catch (Throwable throwable) {
                LOGGER.error("dispatch message ex, packet = {}, connect = {}, body = {}", packet, connection, packet.body, throwable);
            }
        }
    }
}
