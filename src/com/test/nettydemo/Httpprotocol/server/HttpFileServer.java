package com.test.nettydemo.Httpprotocol.server;

import com.test.nettydemo.Httpprotocol.server.HttpFileServerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * 项目名称:JavaTest
 * 描述:
 * 创建人:ryw
 * 创建时间:2017/7/7
 */
public class HttpFileServer {

    private static  final String default_url="/";

    public void run(int port) throws Exception {
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 100)
                    .childHandler(new ChildChannelHandler());

            ChannelFuture future = bootstrap.bind(port).sync();
            System.out.println("Http 文件服务器启动");
            future.channel().closeFuture().sync();
        }finally {
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }

    }

    private class ChildChannelHandler extends ChannelInitializer<SocketChannel>{

        @Override
        protected void initChannel(SocketChannel socketChannel) throws Exception {
            socketChannel.pipeline().addLast("http-decoder",new HttpRequestDecoder());
            socketChannel.pipeline().addLast("http-aggregator",new HttpObjectAggregator(65536));
            socketChannel.pipeline().addLast("http-encoder",new HttpResponseEncoder());
            socketChannel.pipeline().addLast("http-chunked",new ChunkedWriteHandler());
            socketChannel.pipeline().addLast("fileServerHandler",new HttpFileServerHandler(default_url));
        }
    }

    public static void main(String[] args) throws Exception {
       int port = 8999;
       new HttpFileServer().run(port);

    }





}
