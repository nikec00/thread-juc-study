package com.itnkc.sync;

import sun.nio.cs.ext.SJIS;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/12/10 14:09
 */
public class ThreadDemo1 {
    public static void main(String[] args) {
        Share share = new Share();
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                share.add();
            }
        }, "线程1").start();
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                share.remove();

            }
        }, "线程2").start();
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                share.add();
            }
        }, "线程3").start();
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                share.remove();

            }
        }, "线程4").start();
    }

}

class Share {
    private int number = 0;

    public void add() {
        synchronized (this) {
            this.notifyAll();
            if (number == 0) {
                number++;
                System.out.println(Thread.currentThread().getName() + ":number=" + number);
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void remove() {
        synchronized (this) {
            this.notifyAll();
            if (number == 1) {
                number--;
                System.out.println(Thread.currentThread().getName() + ":number=" + number);
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


