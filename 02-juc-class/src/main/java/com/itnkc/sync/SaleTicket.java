package com.itnkc.sync;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/12/10 13:38
 */
public class SaleTicket {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {
                    ticket.sale();
                }
            }
        }, "aa").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {
                    ticket.sale();
                }
            }
        }, "bb").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {
                    ticket.sale();
                }
            }
        }, "cc").start();
    }

}

class Ticket {
    private int ticket = 30;

    public void sale() {
        synchronized (this) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + ": 卖出:" + (ticket--) + "剩下:" + ticket);
            }
        }

    }
}
