package com.test.nio.client;


/**
 * 项目名称:JavaTest
 * 描述:
 * 创建人:ryw
 * 创建时间:2017/7/5
 */
public class NioChannelClient {

    public static  void main(String args[]) throws Exception{
        int port =8089;
        new Thread(new TimeClientHandle("127.0.0.1",port),"EchoClient").start();

    }
}
