package com.itnkc.a04;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/12/9 11:11
 */
public class WindowTest4 {
    public static void main(String[] args) {
        new Window4("窗口1").start();
        new Window4("窗口2").start();
    }
}
class Window4 extends Thread {
    private static int ticket = 100;
    public Window4(String name) {
        super(name);
    }
    @Override
    public void run() {
        while (true) {
            show();
        }
    }
    private static synchronized void show() {
        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + "卖票，票号为:" + ticket);
            ticket--;
        }
    }
}
