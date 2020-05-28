package com.blade.practice.zookeeper;

import com.blade.practice.annotation.Value;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * TODO:
 *
 * @author chenjiangxin
 * @date 2018/9/29 16:05
 */
public class ZookeeperClientUtils {
    @Value("zookeeper.connect.string")
    private static String connectString;

    @Value("zookeeper.session.timeout")
    private static int timeout;

    @Value("zookeeper.exponential.backoff.retry.sleeptime")
    private static int backoffRetrySleepTime;

    @Value("zookeeper.exponential.backoff.retry.times")
    private static int backoffRetryTimes;

    private static CuratorFramework curatorFramework = null;

    public static CuratorFramework getInstance() {

        if(null == curatorFramework) {
            synchronized (ZookeeperClientUtils.class) {
                if (null == curatorFramework) {

                    System.out.println("connectString : " + connectString + " , timeout : " + timeout);

                    curatorFramework = CuratorFrameworkFactory.builder().connectString(connectString)
                            .sessionTimeoutMs(timeout).retryPolicy(
                                    new ExponentialBackoffRetry(backoffRetrySleepTime, backoffRetryTimes))
                            .build();
                }
            }
        }

        return curatorFramework;
    }
}
