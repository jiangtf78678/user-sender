package com.jiangtf.demo.mode;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class TemplateBizService {

    public BaseBizResult<String> query(String bizId){
        CommonBizTemplate commonBizTemplate=new CommonBizTemplate();
        BaseBizResult<String> result=commonBizTemplate.execute(//模板
                new AbstractDefaultBizCallback<String>() {//回调函数
            @Override
            public void beforeCheck() {
                if(StringUtils.isBlank(bizId)){
                    throw  new BizRuntimeException("001","入参id值为空");
                }
                if(StringUtils.equals("a",bizId)){
                    throw  new BizRuntimeException("002","入参id值不能是a");
                }
            }

            @Override
            public String doAction() {
                return "成功返回业务数据";
            }

            @Override
            public void afterAction(String s) {
                System.out.println("111"+StringUtils.equals(s,"成功返回业务数据"));
                System.out.println("222"+StringUtils.equals("s","s"));
                if(StringUtils.equals(s,"成功返回业务数据")){
                    System.out.println("2222记录日志log.....");
                }
            }
        });
        System.out.println("ssss"+result.getData());
        return result;

    }
}
