package com.jiangtf.nettytest.javare.sjms.threadlocal;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLoc {

    public static ThreadLocal<String> threadLocal = new ThreadLocal<>();
    public static ThreadLocal<Integer> initthreadLocal = new ThreadLocal<>();


    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    new TestThreadLocal().D("jiangtf", 26);
                }
            });
            Thread.sleep(10);

        }
        threadPool.shutdown();
    }

    public void A(String name, int age) {
        initthreadLocal.set(new Random().nextInt(1000));
        B(name, age);
    }

    public void B(String name, int age) {
        C(name, age);
    }

    public String C(String name, int age) {
        String d = new TestThreadLocal().D(name, age);
        System.out.println("C----->>>" + name + ":" + age + initthreadLocal.get());
        return d;
    }
}