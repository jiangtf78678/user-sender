package com.jiangtf.demo.mode;

public interface CommonBizCallback<T>{
    //回调接口
    void beforeCheck();
    T doAction();
    void afterAction(T t);
    void finallyAction(T t);
}
