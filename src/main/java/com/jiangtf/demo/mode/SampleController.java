package com.jiangtf.demo.mode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class SampleController {
    @Autowired
    private TemplateBizService templateBizService;
    @RequestMapping(value = "/sss")
    public Map<String,String> query(@RequestParam("id") String  id){
        Map<String,String> map=new HashMap<>();
        BaseBizResult<String> b=templateBizService.query(id);
        if (b.isSucceed()){
            map.put("success",b.getData());
        }else {
            map.put(b.getErrorCode(),b.getErrorMsg());
        }
        return  map;
    }
    @RequestMapping(value = "/hello1")
    public String hello1(String id){
        return  "hello1";
    }
}
