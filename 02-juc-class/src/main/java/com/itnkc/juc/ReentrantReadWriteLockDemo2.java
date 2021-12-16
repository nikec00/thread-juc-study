package com.itnkc.juc;

import java.sql.Time;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/12/16 11:33
 */
class MyCache {

    private volatile Map<String, String> map = new HashMap<>();
    ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void put(String key, String value) {
        try {
            readWriteLock.writeLock().lock();
            System.out.println(Thread.currentThread().getName() + "正在进行写操作：" + key);
            TimeUnit.SECONDS.sleep(1);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "：写完了");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public Object get(String key) {
        readWriteLock.readLock().lock();
        Object result = null;
        try {
            System.out.println(Thread.currentThread().getName() + "正在进行读操作：" + key);
            TimeUnit.SECONDS.sleep(1);
            result = map.get(key);
            System.out.println(Thread.currentThread().getName() + "读完了");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }
        return result;
    }
}

public class ReentrantReadWriteLockDemo2 {
    public static void main(String[] args) {
        MyCache myCache = new MyCache();
        // 创建线程读操作
        for (int i = 1; i <= 5; i++) {
            final int num = i;
            new Thread(() -> {
                myCache.get(String.valueOf(num));
            }, String.valueOf(i)).start();
        }
        // 创建线程写操作
        for (int i = 1; i <= 5; i++) {
            final int num = i;
            new Thread(() -> {
                myCache.put(String.valueOf(num), String.valueOf(num));
            }, String.valueOf(i)).start();
        }


    }
}
