package com.jiangtf.demo.mode;


//默认回调实现
public abstract class AbstractDefaultBizCallback<T>
implements CommonBizCallback<T> {
    @Override
    public void beforeCheck() {

    }

    @Override
    public T doAction() {
        return null;
    }

    @Override
    public void afterAction(T t) {

    }

    @Override
    public void finallyAction(T t) {

    }
}
