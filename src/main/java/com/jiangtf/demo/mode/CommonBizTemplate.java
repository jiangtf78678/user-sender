package com.jiangtf.demo.mode;


//最核心的类。骨架类
public class CommonBizTemplate implements CommonBizOperations {

    @Override
    public <T> BaseBizResult<T> execute(CommonBizCallback<T> callback) {
       T t=null;
       try{
           callback.beforeCheck();
           t=callback.doAction();
           callback.afterAction(t);
           return buildSuccedResult(t);
       }catch (BizRuntimeException e){
            return  buildErrorResult(e.getErrorCode(),e.getErrorMsg());
       }catch (Exception e){
           return  buildErrorResult("911","位置异常");
       }finally {
           callback.finallyAction(t);
       }
    }
    static  <T> BaseBizResult<T> buildSuccedResult(T data){
        return  new BaseBizResult<>(data);
    }

    static BaseBizResult buildErrorResult(String errorCode, String errorMsg){
        return new BaseBizResult(errorCode,errorMsg);
    }
}
