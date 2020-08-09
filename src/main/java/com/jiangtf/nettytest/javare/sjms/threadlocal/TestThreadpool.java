package com.jiangtf.nettytest.javare.sjms.threadlocal;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestThreadpool {

    public static void main(String[] args) {
        ThreadPoolExecutor executor=new ThreadPoolExecutor(5,10,200,
                TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(5));
        for (int i = 0; i <15 ; i++) {
            MyTask myTask=new MyTask(i);
            executor.execute(myTask);
            System.out.println("线程池中的数目："+executor.getPoolSize()+",队列中等待执行的任务:"+
               executor.getQueue().size()+",已执行完别的任务:" +executor.getCompletedTaskCount()    );
        }
        
    }
}
