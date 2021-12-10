package com.itnkc.a08;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/12/9 14:33
 */
public class WindowThread {
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
    Lock lock = new ReentrantLock();
    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();
                if (ticket > 0) {
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + "卖票，票号为:" + ticket);
                    ticket--;
                } else {
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
