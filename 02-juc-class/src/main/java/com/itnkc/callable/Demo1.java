package com.itnkc.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/12/15 20:48
 */
public class Demo1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask futureTask = new FutureTask(new MyThread1());
        while (true) {
            if (!futureTask.isDone()) {
                System.out.println("wait!!");
            }
            break;
        }
        new Thread(futureTask, "aa").start();
        Object o = futureTask.get();
        System.out.println(o);

        System.out.println(Thread.currentThread().getName() + "over!");
    }
}

class MyThread1 implements Callable {

    @Override
    public Object call() throws Exception {
        System.out.println("hahaha");
        return 1;
    }
}
