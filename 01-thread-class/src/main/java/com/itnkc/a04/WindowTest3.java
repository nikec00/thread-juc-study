package com.itnkc.a04;

/**
 * @Description：使用同步方法实现Runnable接口线程安全问题
 * @Author: nkc
 * @Date: 2021/12/9 10:20
 */
public class WindowTest3 {
    public static void main(String[] args) {
        Window3 window = new Window3();
        Thread thread = new Thread(window);
        thread.setName("窗口1");
        Thread thread2 = new Thread(window);
        thread2.setName("窗口2");
        thread.start();
        thread2.start();
    }
}

class Window3 implements Runnable {
    private int ticket = 100;
    @Override
    public void run() {
        while (true) {
            show();
        }
    }
    private synchronized void show() { //同步监视器：this
        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + "卖票，票号为:" + ticket);
            ticket--;
        }
    }
}
