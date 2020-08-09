package com.jiangtf.nettytest.javare.sjms;

import java.util.concurrent.atomic.AtomicLong;

public enum Idgenerator {
    INSTANCE;

    private AtomicLong id=new AtomicLong(0);
    public long getId(){
        return  id.incrementAndGet();
    }

    public static void main(String[] args) {
        Idgenerator instance = Idgenerator.INSTANCE;
        for (int i=0;i<10;i++){
            System.out.println("instance:"+instance+"getId()"+instance.getId());
        }

    }
}
