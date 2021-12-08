package com.itnkc.a03;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/12/8 15:34
 */
public class TestThread2 {
    public static void main(String[] args) {
        WThread wThread = new WThread();
        Thread thread = new Thread(wThread);
        System.out.println(thread.getState());
        thread.start();
        thread.start();
    }
}
class WThread implements Runnable {

    @Override
    public void run() {
        System.out.println("abc");
    }
}
