package com.itnkc.a01;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/12/10 11:39
 */
public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "::" + Thread.currentThread().isDaemon());
        }, "线程1");
        thread.setDaemon(true);
        thread.start();
        System.out.println(Thread.currentThread().getName() + "::" + "over");

    }
}
