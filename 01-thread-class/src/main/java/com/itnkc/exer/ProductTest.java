package com.itnkc.exer;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/12/9 17:04
 */
public class ProductTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Customer customer = new Customer(clerk);
        customer.setName("消费者");
        Productor productor = new Productor(clerk);
        productor.setName("生产者");
        customer.start();
        productor.start();
    }
}

class Clerk {

    private int product = 1;

    public synchronized void produceProduct() {
        if (product < 20) {
            product++;
            System.out.println(Thread.currentThread().getName() + ":开始生产第" + product + "个产品");
            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void consumerProduct() {
        if (product > 0) {
            System.out.println(Thread.currentThread().getName() + ":开始消费第" + product + "个产品");
            product--;
            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Customer extends Thread {
    private Clerk clerk;

    public Customer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + ":开始消费产品");
        clerk.consumerProduct();
    }
}

class Productor extends Thread {
    private Clerk clerk;

    public Productor(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ":开始生产产品。。。");
        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.produceProduct();
        }
    }
}

