package com.itnkc.a04;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/12/8 16:20
 */
public class WindowTest {
    public static void main(String[] args) {
        Window window = new Window();
        Thread thread = new Thread(window);
        thread.setName("窗口1");
        Thread thread2 = new Thread(window);
        thread2.setName("窗口2");
        thread.start();
        thread2.start();

    }
}
class Window implements Runnable {
    private int ticket = 100;
    Object object = new Object();
    @Override
    public void run() {
        while (true) {
            synchronized (object) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":买票，票号为:" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }

        }
    }
}
