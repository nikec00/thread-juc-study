package com.itnkc.a02;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/12/8 14:05
 */
public class ThreadTest1 {
    public static void main(String[] args) {
        //3.创建实现类对象
        MThread mThread = new MThread();
        //4.将此对象作为参数传递到Thread类的构造器种，创建Thread对象
        Thread thread = new Thread(mThread);
        thread.setName("线程1");
        //5.通过Thread类的对象调用start方法
        thread.start();
    }
}

//1. 创建一个实现了Runnable接口的类
class MThread implements Runnable {
    //2. 实现类去实现Runnable种的抽象方法run()
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
