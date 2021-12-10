package com.itnkc.exer;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/12/9 15:06
 */
public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account();
        Thread t1 = new Thread(account);
        t1.setName("储户A");
        Thread t2 = new Thread(account);
        t2.setName("储户B");
        t1.start();
        t2.start();
    }
}

class Account implements Runnable {
    private int money = 0;
    Lock lock = new ReentrantLock(true);

    @Override
    public void run() {
        int count = 0;
        while (true) {
            try {
                lock.lock();
                if (count < 3) {
                    money += 1000;
                    count++;
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + "储户存了1000元，账户余额为：" + money);
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

