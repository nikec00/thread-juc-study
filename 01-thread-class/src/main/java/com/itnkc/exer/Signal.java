package com.itnkc.exer;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/12/10 09:45
 */
public class Signal {

}

class S implements Runnable {
    private int signal = 0;

    @Override
    public void run() {
        while (signal < 5) {
            if (signal % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + signal);
                signal++;
            }
        }
    }
}
