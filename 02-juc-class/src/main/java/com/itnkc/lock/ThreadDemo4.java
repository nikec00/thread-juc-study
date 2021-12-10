package com.itnkc.lock;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @Description： List集合不安全
 * @Author: nkc
 * @Date: 2021/12/10 15:48
 */
public class ThreadDemo4 {
    public static void main(String[] args) {
        //ArrayList<String> list = new ArrayList<>(); //线程不安全
        //List<String> list = new Vector<>();//解决方式1(Vector):不推荐，太老
//        List<String> list = Collections.synchronizedList(new ArrayList<>());//Collections.synchronizedList():不推荐，太老
        Set<String> set = new CopyOnWriteArraySet<>();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(set);
            }, String.valueOf(i)).start();
        }
    }
}
