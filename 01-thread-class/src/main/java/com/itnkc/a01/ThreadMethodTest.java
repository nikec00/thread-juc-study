package com.itnkc.a01;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/12/8 10:25
 */
public class ThreadMethodTest {
    public static void main(String[] args) throws InterruptedException {
        HelloThread t1 = new HelloThread("*子线程");
        Thread.currentThread().setName("主线程");
        t1.start();
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                Thread.sleep(500);
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }

    }
}

/**
 * 测试Thread中的常用方法：
 * 1.start():启动当前线程，调用当前线程的run()
 * 2.run():通常需要重现Thread类中的此方法，将创建线程要执行的操作声明在此方法中。
 * 3.currentThread():静态方法，返回执行当前的代码的线程。
 * 4.getName():获取当前线程的名字。
 * 5.setName():设置当前线程的名字。
 * 6.yield():释放当前cpu的执行权，重新分配。
 * 7.join():在线程a中调用线程b的join()方法，此时线程a就进入阻塞状态，直到线程b执行完毕后，线程a才结束阻塞状态。
 * 8.stop():强制让线程结束。-----（过时，不建议）
 * 9.sleep():让当前线程睡眠，当前线程进入阻塞状态。
 * 10.isAlive():当前线程是否存活
 */
class HelloThread extends Thread {
    public HelloThread() {
    }

    public HelloThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
