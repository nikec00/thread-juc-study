package com.itnkc.juc;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/12/16 12:23
 */
public class jj {
    public static void main(String[] args) {
        ReentrantReadWriteLock readwriteLock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.WriteLock writeLock = readwriteLock.writeLock();
        ReentrantReadWriteLock.ReadLock readLock = readwriteLock.readLock();
        readLock.lock();
        System.out.println("读操作");
        writeLock.lock();
        System.out.println("写操作");
        readLock.unlock();
        writeLock.unlock();

    }
}
