package com.itnkc.a09;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/12/9 15:34
 */
public class CommunicationTest {
    public static void main(String[] args) {
        Communication communication = new Communication();
        Thread thread = new Thread(communication);
        thread.setName("线程1");
        Thread thread2 = new Thread(communication);
        thread2.setName("线程2");
        thread.start();
        thread2.start();
    }
}

class Communication implements Runnable {
    private int number = 1;
    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (number <= 100) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + number);
                    number++;
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }
        }
    }
}
