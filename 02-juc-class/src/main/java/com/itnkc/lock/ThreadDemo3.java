package com.itnkc.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/12/10 15:21
 */
class ShareResource {
    private int flag = 1;

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}

public class ThreadDemo3 {

    public static void main(String[] args) {
        ShareResource resource = new ShareResource();
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        lock.lock();
                        condition.signalAll();
                        if (resource.getFlag() == 1) {
                            for (int i = 0; i < 5; i++) {
                                System.out.println(Thread.currentThread().getName() + ": AA");
                            }
                            resource.setFlag(2);
                            condition.await();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
            }, "AA").start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        lock.lock();
                        condition.signalAll();
                        if (resource.getFlag() == 2) {
                            for (int i = 0; i < 10; i++) {
                                System.out.println(Thread.currentThread().getName() + ": BB");
                            }
                            resource.setFlag(3);
                            condition.await();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
            }, "BB").start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        lock.lock();
                        condition.signalAll();
                        if (resource.getFlag() == 3) {
                            for (int i = 0; i < 15; i++) {
                                System.out.println(Thread.currentThread().getName() + ": CC");
                            }
                            resource.setFlag(1);
                            condition.await();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
            }, "CC").start();
        }

}
