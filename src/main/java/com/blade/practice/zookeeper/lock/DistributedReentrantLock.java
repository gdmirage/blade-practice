package com.blade.practice.zookeeper.lock;

import com.blade.practice.zookeeper.ZookeeperClientUtils;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;

import java.util.concurrent.TimeUnit;

/**
 * TODO:
 * 基于zk的分布式锁
 * @author chenjiangxin
 * @date 2018/11/24 11:14
 */
public class DistributedReentrantLock {

    private InterProcessMutex lock;

    private static String LOCK_PATH = "/lock/";

    private static String LOCK_SUFFIX = "_lock";

    private static CuratorFramework curatorFramework;

    public DistributedReentrantLock(String lockName) {
        curatorFramework = ZookeeperClientUtils.getInstance();
        curatorFramework.start();
        lock = new InterProcessMutex(curatorFramework, LOCK_PATH + lockName + LOCK_SUFFIX);
    }

    public void lock() {

        try {
            lock.acquire();
        } catch (Exception e) {
            System.out.println("lock DistributedReentrantLock fail");
            e.printStackTrace();
        }
    }

    public void unlock() {
        try {
            lock.release();
        } catch (Exception e) {
            System.out.println("unlock DistributedReentrantLock fail");
            e.printStackTrace();
        }
    }

    public boolean tryLock() {
        return tryLock(0, TimeUnit.MILLISECONDS);
    }

    public boolean tryLock(long time, TimeUnit timeUnit) {
        try {
            return lock.acquire(time, timeUnit);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
