package com.itnkc.a10;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/12/10 09:57
 */
public class ThreadNew {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        NumThread numThread = new NumThread();
        FutureTask task = new FutureTask<Integer>(numThread);
        task.run();//启动线程
        //获取FutureTask构造器参数Callable实现类重写call方法的返回值
        Object o = task.get();
        System.out.println(o);

    }
}

class NumThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}


