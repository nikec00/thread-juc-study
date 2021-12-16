package com.itnkc.juc;

import java.util.concurrent.CountDownLatch;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/12/15 22:23
 */
public class CountDownLatchDemo2 {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(4);
        for (int i = 1; i <= 4; i++) {
            new Thread(() -> {
                try {
                    System.out.println("选手：" + Thread.currentThread().getName() + "正在等待裁判发布口令");
                    countDownLatch.await();
                    System.out.println("选手" + Thread.currentThread().getName() + "已接受裁判口令");
                    Thread.sleep((long) (Math.random() * 10000));
                    System.out.println("选手" + Thread.currentThread().getName() + "到达终点");
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }

        try {
            Thread.sleep((long) (Math.random() * 10000));
            System.out.println("裁判：" + Thread.currentThread().getName() + "即将发布口令");
            countDownLatch.countDown();
            System.out.println("裁判" + Thread.currentThread().getName() + "已发送口令，正在等待所有选手到达终点");
            countDownLatch.await();
            System.out.println("所有选手都到达终点");
            System.out.println("裁判"+Thread.currentThread().getName()+"汇总成绩排名");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        countDownLatch.countDown();
    }
}
