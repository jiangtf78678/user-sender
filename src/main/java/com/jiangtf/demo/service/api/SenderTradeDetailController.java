package com.jiangtf.demo.service.api;


import com.fasterxml.uuid.Generators;
import com.jiangtf.demo.entity.TradeDeails;
import com.jiangtf.demo.service.TradeDetailsService;
import com.jiangtf.demo.utils.GeneratorDataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SenderTradeDetailController {


    @Autowired
    private TradeDetailsService tradeDetailsService;
    @RequestMapping(value = "/hello2")
    public String hello1(String id){
        return  "hello2";
    }
    @RequestMapping("/sender")
    public  void sender(@RequestParam("count") Integer count) throws  Exception{
        for (int i = 0; i < count; i++) {
            //获取数据
           TradeDeails tradeDeail = GeneratorDataUtil.generator();
           //拿到数据，调用service
            tradeDetailsService.sender(tradeDeail);
        }
    }


    @RequestMapping("/sqlTest")
    @ResponseBody
    public List<TradeDeails> sqlTest(){
        return tradeDetailsService.sqlTestService();
    }

}
