package com.itnkc.a04;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/12/9 09:58
 */
public class WindowTest2 {
    public static void main(String[] args) {
        new Window2("窗口1").start();
        new Window2("窗口2").start();
    }
}

class Window2 extends Thread {
    private static int ticket = 100;
    private static Object lock = new Object();

    public Window2(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "卖票，票号为:" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }

        }
    }
}