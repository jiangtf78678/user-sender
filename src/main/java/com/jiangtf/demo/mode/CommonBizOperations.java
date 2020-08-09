package com.jiangtf.demo.mode;


//模板方法的接口
public interface CommonBizOperations {
    <T> BaseBizResult<T> execute(CommonBizCallback<T> callback);

}
