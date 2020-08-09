package com.jiangtf.demo.lisener;

import com.jiangtf.demo.netty.NettyClient;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component("springListener")
public class SpringListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        //需要执行的逻辑代码，当spring容器初始化完成后就会执行该方法
        System.out.println("srping加载完毕...");
        try{
//            NettyClient client= NettyClient.getInstance().connect();
//            NettyClient.getInstance().connect();
//            com.jiangtf.nettytest.client.NettyClient client = new NettyClient("127.0.0.1", 8080);
            //启动client服务
//            client.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
