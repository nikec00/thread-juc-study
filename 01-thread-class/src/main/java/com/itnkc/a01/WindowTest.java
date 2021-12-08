package com.itnkc.a01;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/12/8 11:53
 */
public class WindowTest {
    public static void main(String[] args) {
        new Window("窗口1").start();
        new Window("窗口2").start();
    }
}

class Window extends Thread {
    private static Integer ticket = 100;

    public Window() {
    }

    public Window(String name){
        super(name);
    }
    @Override
    public void run() {
            while (true) {
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "卖票，票号为" + ticket);
                    ticket--;
                } else {
                    break;
                }
        }

    }
}
