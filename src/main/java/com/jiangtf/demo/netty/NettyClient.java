package com.jiangtf.demo.netty;

import com.jiangtf.demo.protocal.Req;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.timeout.ReadTimeoutHandler;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class NettyClient {
    private static class singletionHolder{
        static  final NettyClient instance=new NettyClient();
    }
    public static NettyClient getInstance(){
        return singletionHolder.instance;
    }
    private String host="127.0.0.1";
    private int port=1234;
    private ChannelFuture cf;
    private EventLoopGroup group;
    private Bootstrap b;
    private NettyClient(){
        group=new NioEventLoopGroup();
        b=new Bootstrap();
        b.group(group)
         .channel(NioSocketChannel.class)
         .handler(new ChannelInitializer<SocketChannel>() {
             @Override
             protected void initChannel(SocketChannel sc) throws Exception {
                sc.pipeline().addLast(MarshallingCodeFactory.buildMarshallingDecoder());
                sc.pipeline().addLast(MarshallingCodeFactory.buildMarshallingEncoder());
//                 sc.pipeline().addLast(new ReadTimeoutHandler(50));
                sc.pipeline().addLast(new NettyClientHandler());
             }
         });
    }
    public  void connect(){
        try {
            this.cf=this.b.connect(host,port).sync();
            if (cf.isSuccess()){
                System.out.println("sender远程服务已经连接，可以进行通信。。。");
            }else {
                System.out.println("sender远程服务启动失败！！！。。。");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void close(){
        try {
            this.cf.channel().closeFuture().sync();
            this.group.shutdownGracefully();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
/**
 * @Author jiangtf
 * @Description 供外部servie.api调用
 * @Date 13:58 2020/3/19
 * @Param []
 * @return io.netty.channel.ChannelFuture
 **/
    public ChannelFuture getChannelFuture(){
        if (this.cf==null){
            this.connect();
        }
        if (!this.cf.channel().isActive()){
            this.connect();
        }
        return this.cf;

    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

}
