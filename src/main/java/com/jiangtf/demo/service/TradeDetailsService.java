package com.jiangtf.demo.service;

import com.alibaba.fastjson.JSONObject;
import com.jiangtf.demo.dao.TradeDeailsMapper;
import com.jiangtf.demo.entity.TradeDeails;
import com.jiangtf.demo.protocal.Req;
import com.jiangtf.demo.utils.Const;
import com.jiangtf.nettytest.client.NettyClient;
import com.jiangtf.nettytest.client.protocol.RpcRequest;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TradeDetailsService {

    @Autowired
    private TradeDeailsMapper tradeDeailsMapper;



    public List<TradeDeails>  sqlTestService(){
        List<String> ls=new ArrayList<String>();
        ls.add("1");
        ls.add("2");
        ls.add("4");
        String strlist="1,2,4";
        List<TradeDeails> result=tradeDeailsMapper.queryByNotSync(ls);
        return  result;
    }

    @Transactional
    public  void sender(TradeDeails td) throws Exception {
        System.out.println("insins:{}:ins");
        //1。insert
        tradeDeailsMapper.insert(td);
        //2.transfer
//        ChannelFuture cf= NettyClient.getInstance().getChannelFuture();
//        Req req=new Req();
//        req.setId(td.getId());
//        req.setReqeustMessage(JSONObject.toJSONString(td));
//        req.setTag(Const.TRADE_DETAIL);
//        req.setType(Const.SAVE);
//        System.out.println("req: {}"+JSONObject.toJSONString(td));
//        ChannelFuture res=cf.channel().writeAndFlush(req);
   //v2
        NettyClient client = new NettyClient("127.0.0.1", 8080);
        //启动client服务
        client.start();

        Channel channel = client.getChannel();
        //消息体
        RpcRequest request = new RpcRequest();
//        request.setId(UUID.randomUUID().toString());
        request.setId("123456");
        request.setData(td);
        //channel对象可保存在map中，供其它地方发送消息
        channel.writeAndFlush(request);

    }
    public int updateStatusById(String id) {
        return  tradeDeailsMapper.updateStatusById(id);
    }
}
