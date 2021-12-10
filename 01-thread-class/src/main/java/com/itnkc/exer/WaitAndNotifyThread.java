package com.itnkc.exer;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/12/10 09:28
 */
public class WaitAndNotifyThread {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        Thread t1 = new Thread(a);
        t1.setName("窗口1");
        Thread t2 = new Thread(b);
        t2.setName("窗口2");
        t1.start();
        t2.start();
    }

    static Object lock = new Object();

    static class A implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    try {
                        lock.notify();
                        System.out.println(Thread.currentThread().getName() + ":" + i);
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    static class B implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    try {
                        lock.notify();
                        System.out.println(Thread.currentThread().getName() + ":" + i);
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}


