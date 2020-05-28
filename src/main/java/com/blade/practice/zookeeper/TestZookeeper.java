package com.blade.practice.zookeeper;

import com.blade.practice.multithreads.ThreadPoolHelper;
import com.blade.practice.zookeeper.lock.DistributedReentrantLock;
import com.blade.practice.scan.ScanAnnotation;
import org.apache.curator.framework.CuratorFramework;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * TODO:
 *
 * @author chenjiangxin
 * @date 2018/9/29 14:59
 */
public class TestZookeeper {

    public static void main(String[] args) throws Exception {

        ScanAnnotation.scan();

//        threadLockTest();
        threadTryLockTest();
    }

    private static void createNodeTest() throws Exception {
        CuratorFramework curatorFramework = ZookeeperClientUtils.getInstance();
        curatorFramework.start();
        curatorFramework.create().creatingParentsIfNeeded().forPath("/blade1/bbb", "haha".getBytes("UTF-8"));
    }

    private static void lockTest() throws InterruptedException {
        DistributedReentrantLock lock = new DistributedReentrantLock("blade");

        lock.lock();
//        System.out.println(lock.tryLock());
        Thread.sleep(5000);
        System.out.println("another lock start");
        lock.lock();
        System.out.println("another lock end");
//        System.out.println(lock.tryLock());
        Thread.sleep(10000);
        lock.unlock();
        lock.unlock();
    }

    private static void threadLockTest() throws Exception {
        DistributedReentrantLock lock = new DistributedReentrantLock("blade");

        ThreadPoolExecutor executor = new ThreadPoolHelper("ZookeeperLock").getExecutorPoolExecutor();

        for (int i = 0; i < 10; i++) {
            int j = i;

            Thread t = new Thread(()->{
                try {
                    System.out.println("this is thread " + j + " trying get lock");
                    lock.lock();
                    System.out.println("---thread " + j +" get lock success");
                    TimeUnit.SECONDS.sleep(1);
                }catch (Exception e) {
                    System.out.println("thread " + j +" get lock un success");
                }finally {
                    lock.unlock();
                    System.out.println("thread " + j +" un lock now");
                }
            });
            executor.execute(t);
        }
        executor.shutdown();
    }

    private static void threadTryLockTest() throws Exception {
        DistributedReentrantLock lock = new DistributedReentrantLock("blade");

        ThreadPoolExecutor executor = new ThreadPoolHelper("ZookeeperLock").getExecutorPoolExecutor();

        for (int i = 0; i < 10; i++) {
            int j = i;

            Thread t = new Thread(()->{
                try {
                    if(lock.tryLock(1, TimeUnit.SECONDS)) {
                        System.out.println("---thread " + j +" get lock success");
                        TimeUnit.SECONDS.sleep(2);
                        lock.unlock();
                        System.out.println("thread " + j +" un lock now");
                    }else {
                        System.out.println("---thread " + j +" get lock fail");
                    }
                }catch (Exception e) {
                    System.out.println("thread " + j +" get lock un success");
                }
            });
            executor.execute(t);
        }
        executor.shutdown();
    }
}
