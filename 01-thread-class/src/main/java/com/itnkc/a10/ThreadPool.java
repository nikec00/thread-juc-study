package com.itnkc.a10;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Description： 线程池实现
 * @Author: nkc
 * @Date: 2021/12/10 10:30
 */
public class ThreadPool {
    public static void main(String[] args) {
        //1.提供指定数量的线程池
        ThreadPoolExecutor threadPool = (ThreadPoolExecutor) Executors.newFixedThreadPool(1);
        threadPool.setCorePoolSize(10);
        threadPool.setKeepAliveTime(10, TimeUnit.SECONDS);
        //2.设置线程池属性
        threadPool.execute(new MyThread());
        threadPool.execute(new MyThread2());
        //关闭连接池
        threadPool.shutdown();
    }
}

class MyThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}
class MyThread2 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}
