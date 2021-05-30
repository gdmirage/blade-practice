package com.blade.practice.project.connect;

import com.blade.practice.project.server.NamedPoolThreadFactory;
import io.netty.channel.Channel;
import io.netty.util.HashedWheelTimer;

import java.util.concurrent.TimeUnit;

/**
 * TODO:
 *
 * @author blade
 * 2021/5/30 10:03
 */
public class ServerConnectionManager implements ConnectionManager {

    private final ConnectionHolder DEFAULT = new SimpleConnectionHolder();
    private final boolean heartbeatCheck;
    private final ConnectionHolderFactory holderFactory;
    private HashedWheelTimer timer;

    public ServerConnectionManager(boolean heartbeatCheck) {
        this.heartbeatCheck = heartbeatCheck;
        this.holderFactory = heartbeatCheck ? HeartbeatCheckTask::new : SimpleConnectionHolder::new;
    }

    @Override
    public int getConnNum() {
        return 0;
    }

    @Override
    public Connection get(Channel channel) {
        return null;
    }

    @Override
    public Connection removeAndClose(Channel channel) {
        return null;
    }

    @Override
    public void add(Connection connection) {

    }

    @Override
    public void init() {
        if (heartbeatCheck) {
            // 每秒钟走一步，一个心跳周期内大致走一圈
            long tickDuration = TimeUnit.SECONDS.toMillis(1);
            // 10 需要配置文件配置
            int tickPerWheel = (int) (10 / tickDuration);
            this.timer = new HashedWheelTimer(new NamedPoolThreadFactory("conn_timer"),
                    tickDuration, TimeUnit.MILLISECONDS, tickPerWheel);
        }
    }

    @Override
    public void destroy() {
        if (null != this.timer) {
            this.timer.stop();
        }

    }

    public static class HeartbeatCheckTask {

    }
}
