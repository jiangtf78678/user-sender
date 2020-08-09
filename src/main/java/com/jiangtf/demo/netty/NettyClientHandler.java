package com.jiangtf.demo.netty;
import com.jiangtf.demo.lisener.ApplicationFactory;
import com.jiangtf.demo.protocal.Req;
import com.jiangtf.demo.protocal.Resp;
import com.jiangtf.demo.service.TradeDetailsService;
import com.jiangtf.demo.utils.Const;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

public class NettyClientHandler extends ChannelInboundHandlerAdapter {
    public void channelRead(ChannelHandlerContext ctx,Object msg)throws  Exception{
        try{
            Resp resp= (Resp) msg;
            String id=resp.getId();
            String tag=resp.getTag();
            String type=resp.getType();
            String responseCode=resp.getResponseCode();
            String responseMassage=resp.getResponseMessage();
            if (Const.TRADE_DETAIL.equals(tag)){
                TradeDetailsService tradeDetailsService= (TradeDetailsService) ApplicationFactory.getBean("tradeDetailsService");
               //success
                if (Const.RESPONSE_CODE_OK.equals(responseCode))
                    if (Const.UPDATE.equals(type)){
                     System.out.println("更新同步标识------：id"+id);
                tradeDetailsService.updateStatusById(id);
                    }
            }
        }finally {
            ReferenceCountUtil.release(msg);
        }
    }
}
