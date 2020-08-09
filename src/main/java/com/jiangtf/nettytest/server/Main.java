package com.jiangtf.nettytest.server;

import com.jiangtf.nettytest.server.server.NettyServer;
/**
 * <uv> [2018/10/13 19:52]
 */
public class Main {

    public static void main(String[] args) throws Exception {
        //启动server服务
        new NettyServer().bind(8080);
    }
}
