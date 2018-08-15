package com.test.nettydemo.Linebaseframedecoder.client;


import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;


/**
 * 项目名称:JavaTest
 * 描述:
 * 创建人:ryw
 * 创建时间:2017/7/13
 */
public class TimeClientHandler extends ChannelInboundHandlerAdapter{


    //private final ByteBuf buf;
    private int counter;

    private  byte[] req;

    public TimeClientHandler() {
        req = ("QUERY TIME ORDER"+System.getProperty("line.separator").length()).getBytes();
        //buf = Unpooled.buffer(req.length);
        //buf.writeBytes(req);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("start send");
        ByteBuf message = null;
        for (int i = 0; i < 100; i++) {
            message = Unpooled.buffer(req.length);
            message.writeBytes(req);
            ctx.writeAndFlush(message);
        }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("start read");
        String s = (String) msg;
        System.out.println("now is:"+s + "the counter is:" + ++counter);
    }

//    @Override
//    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        ByteBuf buf = (ByteBuf)msg;
//        byte[] bytes = new byte[buf.readableBytes()];
//        buf.readBytes(bytes);
//        String s = new String(bytes, "utf-8");
//        System.out.println("now is:"+s + "the counter is:" + ++counter);
//    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("exception"+cause.getMessage());
        ctx.close();
    }
}
