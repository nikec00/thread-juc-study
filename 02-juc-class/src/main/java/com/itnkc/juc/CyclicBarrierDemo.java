package com.itnkc.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @Description：集齐7颗龙珠召唤神龙
 * @Author: nkc
 * @Date: 2021/12/15 21:46
 */
public class CyclicBarrierDemo {
    public static final int NUMBER = 7;

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(NUMBER, new MyThread());
        for (int i = 1; i <= 7; i++) {
            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + "颗龙珠");
                    cyclicBarrier.await(5, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                } catch (TimeoutException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("集齐7颗龙珠召唤神龙");
    }
}
