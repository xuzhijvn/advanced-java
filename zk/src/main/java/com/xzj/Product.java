package com.xzj;

/**
 * Create by xuzhijun.online on 2019/12/4.
 */
public class Product {
    //商品数量
    private static int num = 100;

    //秒杀商品
    public static void seckill() {

        System.out.println("***************秒杀开始***************");

        System.out.println("秒杀前商品余量：" + num);

        //商品数减1
        num--;

        System.out.println("秒杀后商品余量：" + num);

        try {

            //模拟秒杀过程花费的时间
            Thread.sleep(500);

        } catch (Exception e) {

            e.printStackTrace();

        }

        System.out.println("***************秒杀结束***************");

        System.out.println();

    }

}