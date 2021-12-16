package com.itnkc.juc;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/12/16 10:59
 */
public class ReentrantReadWriteLockDemo {
    public static void main(String[] args) {
        ReentrantReadWriteLock writeLock = new ReentrantReadWriteLock();
        for (int i = 1; i <= 2; i++) {
            new Thread(() -> {
                try {
                    writeLock.writeLock().lock();
                    System.out.println("获取写锁：" + Thread.currentThread().getName() + ":" + System.currentTimeMillis());
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    writeLock.writeLock().unlock();
                }
            }, String.valueOf(i)).start();

        }
    }
}
