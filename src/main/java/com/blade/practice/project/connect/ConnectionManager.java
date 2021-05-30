package com.blade.practice.project.connect;

import io.netty.channel.Channel;

/**
 * TODO:
 *
 * @author blade
 * 2021/5/29 10:51
 */
public interface ConnectionManager {

    int getConnNum();

    Connection get(Channel channel);

    Connection removeAndClose(Channel channel);

    void add(Connection connection);

    void init();

    void destroy();
}
