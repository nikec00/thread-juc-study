package com.itnkc.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/12/10 14:33
 */
public class TestDemo2 {
    public static void main(String[] args) {
        Share share = new Share();
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                share.add();
            }
        }, "线程12").start();
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                share.remove();
            }
        }, "线程2").start();
    }
}


class Share {
    private int number = 0;
    ReentrantLock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void add() {
        try {
            lock.lock();
            condition.signalAll();
            if (number == 0) {
                number++;
                System.out.println(Thread.currentThread().getName() + ":number=" + number);
                condition.await();
            }
        } catch (Exception e) {
            e.printStackTrace();
            lock.unlock();
        } finally {
            lock.unlock();
        }
    }


    public void remove() {
        try {
            lock.lock();
            condition.signalAll();
            if (number == 1) {
                number--;
                System.out.println(Thread.currentThread().getName() + ":number=" + number);
                condition.await();
            }
        } catch (Exception e) {
            e.printStackTrace();
            lock.unlock();
        } finally {
            lock.unlock();
        }

    }
}
