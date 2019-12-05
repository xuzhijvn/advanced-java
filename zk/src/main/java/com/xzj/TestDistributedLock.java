package com.xzj;

/**
 * 秒杀停止在第60次循环，原因尚不明确
 *
 * Create by xuzhijun.online on 2019/12/4.
 */
public class TestDistributedLock {

    public static void main(String[] args) {

        //创建100个线程，模拟100个秒杀用户
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    new Client().start();
                }
            }).start();

        }

    }

}