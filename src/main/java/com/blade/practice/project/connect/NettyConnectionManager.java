package com.blade.practice.project.connect;

import io.netty.channel.Channel;
import io.netty.channel.ChannelId;

import java.util.concurrent.ConcurrentHashMap;

/**
 * TODO:
 *
 * @author blade
 * 2021/5/29 11:02
 */
public class NettyConnectionManager implements ConnectionManager {
    ConcurrentHashMap<ChannelId, Connection> connections = new ConcurrentHashMap<>();

    @Override
    public int getConnNum() {
        return connections.size();
    }

    @Override
    public Connection get(Channel channel) {
        return connections.get(channel.id());
    }

    @Override
    public Connection removeAndClose(Channel channel) {
        return connections.remove(channel.id());
    }

    @Override
    public void add(Connection connection) {
        connections.putIfAbsent(connection.getChannel().id(), connection);
    }

    @Override
    public void init() {

    }

    @Override
    public void destroy() {
        connections.values().forEach(Connection::close);
        connections.clear();
    }
}
