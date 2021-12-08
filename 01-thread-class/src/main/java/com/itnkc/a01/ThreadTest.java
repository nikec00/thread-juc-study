package com.itnkc.a01;

/**
 * @Description： 多线程创建
 * 方式一：继承于Thread类
 * 1）.创建一个继承于Thread类的子类
 * 2）.重写run方法()
 * 3）.创建Thread类子类的对象
 * 4）.通过此对象调用start()
 * 例子：遍历100以内的所有偶数
 * @Author: nkc
 * @Date: 2021/12/7 22:28
 */
public class ThreadTest {
    public static void main(String[] args) {
        new MyThread().start();
        new MyThread().start();
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName());
                System.out.println(i + "*****main()*****");
            }
        }
    }
}
class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName());
                System.out.println(i);
            }
        }
    }
}