package com.xzj;


import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * Create by xuzhijun.online on 2019/12/4.
 */
public class Client {

    //开始秒杀
    public void start() {
        //重试策略
        RetryPolicy rp = new ExponentialBackoffRetry(1000, 10);
        //客户端
        CuratorFramework client = CuratorFrameworkFactory.builder()
                .connectString("129.204.253.9:2181").retryPolicy(rp).build();
        client.start();
        //分布式锁
        final InterProcessMutex lock = new InterProcessMutex(client, "/mylock");
        //开始秒杀
        try {
            //获取分布式锁
            lock.acquire();
            System.out.println(Thread.currentThread().getName() + "获得锁");
            //秒杀商品
            Product.seckill();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                //释放分布式锁
                lock.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}