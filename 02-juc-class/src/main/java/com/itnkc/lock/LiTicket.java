package com.itnkc.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/12/10 13:53
 */
public class LiTicket {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.sale();
            }
        }, "aa").start();
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.sale();
            }
        }, "bb").start();
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.sale();
            }
        }, "cc").start();
    }
}

class Ticket {
    private int ticket = 30;
    ReentrantLock lock = new ReentrantLock();

    public void sale() {
        try {
            lock.lock();
            Thread.sleep(100);
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + ": 卖出:" + (ticket--) + "剩下:" + ticket);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            lock.unlock();
        } finally {
            lock.unlock();
        }
    }

}
