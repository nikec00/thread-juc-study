package com.itnkc.a06;

import java.util.Date;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/12/9 13:54
 */
public class TestThread {
    public static String str1 = "a1";
    public static String str2 = "b1";

    public static void main(String[] args) {
        A a = new A();
        new Thread(a).start();
        B b = new B();
        new Thread(b).start();
    }
}

class A implements Runnable {
    @Override
    public void run() {
        while (true) {
            synchronized (TestThread.str1) {
                System.out.println(new Date().toString() + "线程A锁住了a1锁");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (TestThread.str2) {
                    System.out.println(new Date().toString() + "线程A执行了b1锁");
                }
            }

        }
    }
}

class B implements Runnable {
    @Override
    public void run() {
        while (true) {
            synchronized (TestThread.str2) {
                System.out.println(new Date().toString() + "线程B锁住了b1锁");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (TestThread.str1) {
                    System.out.println(new Date().toString() + "线程B执行了a1锁");
                }
            }
        }
    }
}