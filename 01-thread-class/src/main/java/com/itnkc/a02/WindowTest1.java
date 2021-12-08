package com.itnkc.a02;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/12/8 14:27
 */
public class WindowTest1 {
    public static void main(String[] args) {
        window1 window1 = new window1();
        Thread thread = new Thread(window1);
        thread.setName("窗口1");
        Thread thread2 = new Thread(window1);
        thread2.setName("窗口2");
        thread.start();
        thread2.start();
    }
}

class window1 implements Runnable {

    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + ":买票，票号为:" + ticket);
                ticket--;
            } else {
                break;
            }
        }
    }
}
