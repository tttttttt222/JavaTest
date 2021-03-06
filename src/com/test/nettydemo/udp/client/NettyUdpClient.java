package com.test.nettydemo.udp.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

/**
 * 项目名称:testProject
 * 描述:
 * 创建人:ryw
 * 创建时间:2018/5/7
 */
public class NettyUdpClient {

    public void run() throws Exception {
        EventLoopGroup workerGroup  = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            //由于我们用的是UDP协议，所以要用NioDatagramChannel来创建
            b.group(workerGroup).channel(NioDatagramChannel.class)
                    .option(ChannelOption.SO_RCVBUF, 1024 * 1024)// 设置UDP读缓冲区为1M
                    .option(ChannelOption.SO_SNDBUF, 1024 * 1024)// 设置UDP写缓冲区为1M
                    .handler(new ChannelInitializer<NioDatagramChannel>() {
                        @Override
                        protected void initChannel(NioDatagramChannel nioDatagramChannel) throws Exception {
                            nioDatagramChannel.pipeline().addLast(new IdleStateHandler(0, 5, 0, TimeUnit.SECONDS));
                            nioDatagramChannel.pipeline().addLast(new ConnectorIdleStateTrigger());
                            nioDatagramChannel.pipeline().addLast(new ClientHandler());
                        }
                    });
            ChannelFuture future = b.bind(0).sync();
            future.channel().closeFuture().sync();
        }finally {
            workerGroup .shutdownGracefully();
        }
    }


    public static void main(String[] args) throws Exception {
        new NettyUdpClient().run();
    }
}
