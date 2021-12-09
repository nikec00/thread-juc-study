package com.itnkc.单例模式;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/12/9 11:28
 */
public class Bank {
    public Bank() {


    }

    private static Bank instance = null;

    public static Bank getInstance() {
        if (instance == null){
            synchronized (Bank.class) {
                if (instance == null) {
                    instance = new Bank();
                }
            }
        }
        return instance;
    }
}
