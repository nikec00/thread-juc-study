package com.itnkc.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/12/15 20:48
 */
public class Demo1 {
    public static void main(String[] args) {
        FutureTask futureTask = new FutureTask(new MyThread1());
        futureTask.run();
    }
}

class MyThread1 implements Callable {

    @Override
    public Object call() throws Exception {
        return 1;
    }
}
