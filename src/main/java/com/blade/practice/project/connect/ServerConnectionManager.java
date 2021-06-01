package com.blade.practice.project.connect;

import com.blade.practice.project.server.NamedPoolThreadFactory;
import io.netty.channel.Channel;
import io.netty.channel.ChannelId;
import io.netty.util.HashedWheelTimer;
import io.netty.util.Timeout;
import io.netty.util.TimerTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * TODO:
 *
 * @author blade
 * 2021/5/30 10:03
 */
public class ServerConnectionManager implements ConnectionManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(ServerConnectionManager.class);

    private final ConcurrentHashMap<ChannelId, ConnectionHolder> connections = new ConcurrentHashMap<>();
    private final ConnectionHolder DEFAULT = new SimpleConnectionHolder(null);
    private final boolean heartbeatCheck;
    private final ConnectionHolderFactory holderFactory;
    private HashedWheelTimer timer;

    public ServerConnectionManager(boolean heartbeatCheck) {
        this.heartbeatCheck = heartbeatCheck;
        this.holderFactory = heartbeatCheck ? HeartbeatCheckTask::new : SimpleConnectionHolder::new;
    }

    @Override
    public int getConnNum() {
        return connections.size();
    }

    @Override
    public Connection get(Channel channel) {
        return connections.getOrDefault(channel.id(), DEFAULT).get();
    }

    @Override
    public Connection removeAndClose(Channel channel) {
        ConnectionHolder holder = connections.remove(channel.id());
        if (null != holder) {
            Connection connection = holder.get();
            holder.close();
            return connection;
        }

        Connection connection = new NettyConnection();
        connection.init(channel, false);
        connection.close();
        return connection;
    }

    @Override
    public void add(Connection connection) {
        connections.put(connection.getChannel().id(), holderFactory.create(connection));
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

    private interface ConnectionHolderFactory {
        ConnectionHolder create(Connection connection);
    }

    private interface ConnectionHolder {
        Connection get();

        void close();
    }

    private static class SimpleConnectionHolder implements ConnectionHolder {

        public SimpleConnectionHolder(Connection connection) {
            this.connection = connection;
        }

        private final Connection connection;

        @Override
        public Connection get() {
            return this.connection;
        }

        @Override
        public void close() {
            if (null != this.connection) {
                this.connection.close();
            }
        }
    }

    private class HeartbeatCheckTask implements ConnectionHolder, TimerTask {

        private byte timeoutTimes = 0;
        private final Connection connection;

        public HeartbeatCheckTask(Connection connection) {
            this.connection = connection;
            startTimeout();
        }

        void startTimeout() {
            Connection connection = this.connection;

            if (null != connection && connection.isConnected()) {
                int timeout = connection.getSessionContext().heartbeat;
                timer.newTimeout(this, timeout, TimeUnit.MILLISECONDS);

            }
        }

        @Override
        public void run(Timeout timeout) throws Exception {
            Connection connection = this.connection;
            if (null == connection || !connection.isConnected()) {
                LOGGER.info("heartbeat timeout times={}, connection disconnected, conn={}", timeoutTimes, connection);
                return;
            }

            if (connection.isReadTimeout()) {
                // 10 需要配置化
                if (++timeoutTimes > 10) {
                    connection.close();
                    LOGGER.info("client heartbeat timeout times={}, do close conn={}", timeoutTimes, connection);
                    return;
                } else {
                    LOGGER.info("client heartbeat timeout times={}, connection={}", timeoutTimes, connection);
                }
            } else {
                timeoutTimes = 0;
            }

            startTimeout();
        }

        @Override
        public Connection get() {
            return this.connection;
        }

        @Override
        public void close() {
            if (null != connection) {
                connection.close();
            }
        }
    }
}
