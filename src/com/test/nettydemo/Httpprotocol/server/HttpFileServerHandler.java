package com.test.nettydemo.Httpprotocol.server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.handler.codec.http.*;
import io.netty.handler.stream.ChunkedFile;
import io.netty.util.CharsetUtil;
import org.omg.CosNaming.NamingContextPackage.NotFound;

import javax.activation.MimeType;
import javax.activation.MimetypesFileTypeMap;
import java.io.File;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.file.Files;

import static io.netty.handler.codec.http.HttpResponseStatus.OK;

/**
 * 项目名称:JavaTest
 * 描述:
 * 创建人:ryw
 * 创建时间:2017/7/13
 */
public class HttpFileServerHandler extends SimpleChannelInboundHandler<FullHttpRequest> {



    enum Error_Code {
        BAD_REQUEST,
        METHOD_NOT_ALLOWED,
        FORBIDDEN,
        NOT_FOUND
    }

    private String url;

    public HttpFileServerHandler(String url) {
        this.url = url;
    }


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, FullHttpRequest request) throws Exception {
        if (!request.getDecoderResult().isSuccess()) {
            sendError(ctx, Error_Code.BAD_REQUEST);
            return;
        }
        if (request.getMethod() != HttpMethod.GET) {
            sendError(ctx, Error_Code.METHOD_NOT_ALLOWED);
            return;
        }
        final String uri = request.getUri();
        String path = createPath(uri);
        File file = new File(path);
        if (file.isHidden() || !file.exists()) {
            sendError(ctx, Error_Code.NOT_FOUND);
            return;
        }
        //判断文件类型
        if (!file.isDirectory()) {
            //下载
            //System.out.println("文件");
            sendFileToClient(ctx,file,uri);
            return;
//            RandomAccessFile raf = new RandomAccessFile(file, "r");
//            long length = raf.length();
//            DefaultFullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1,OK);
//            response.headers().set("Content-length",length);
//            MimetypesFileTypeMap mimetypesFileTypeMap = new MimetypesFileTypeMap();
//            response.headers().set("Content-type",mimetypesFileTypeMap.getContentType(file.getPath()));
//            if(request.headers().get("Connection").equals("keep-alive")){
//                response.headers().set("Connection", "keep-alive");
//            }
//            ctx.write(response);
//            ChannelFuture sendFileFuture= ctx.write(new ChunkedFile(raf, 0, length, 8192), ctx.newProgressivePromise());
//            sendFileFuture.addListener(new ChannelProgressiveFutureListener() {
//                @Override
//                public void operationProgressed(ChannelProgressiveFuture future, long progress, long total) throws Exception {
//                    if(total < 0)
//                        System.err.println("Transfer progress: " + progress);
//                    else
//                        System.err.println("Transfer progress: " + progress + "/" + total);
//                }
//
//                @Override
//                public void operationComplete(ChannelProgressiveFuture future) throws Exception {
//                    System.out.println("Transfer complete.");
//                }
//            });
//            ChannelFuture lastHttpContent = ctx.writeAndFlush(LastHttpContent.EMPTY_LAST_CONTENT);
//            if(!request.headers().get("Connection").equals("keep-alive")) {
//                lastHttpContent.addListener(ChannelFutureListener.CLOSE);
//            }

        } else if (file.isDirectory()) {
            //显示文件
            //System.out.println("文件夹");
            String[] filelist = file.list();
            StringBuilder sb = new StringBuilder();
            sb.append("<ul>");
            for (int i = 0; i < filelist.length; i++) {
                sb.append("<li><a href='");
//                sb.append(uri.substring(uri.indexOf("/")+1)+"/"+filelist[i]);
                sb.append(uri.substring(uri.lastIndexOf("/")+1)+"/"+filelist[i]);
                sb.append("'>");
                sb.append(filelist[i]);
                sb.append("</a></li>");
            }
            sb.append("</ul>");
            createResponse(ctx, sb.toString());
            return;
        }
        ctx.close();
    }



    private String createPath(String uri) {
//        String substring = uri.substring(uri.indexOf("/"));
        return "D:" + uri.replace("/",File.separator);
//        return "/" + uri.replace("/",File.separator);
    }


    private void sendError(ChannelHandlerContext ctx, Error_Code badRequest) {
        switch (badRequest) {
            case BAD_REQUEST:
                createResponse(ctx, "BAD_REQUEST");
                break;
            case METHOD_NOT_ALLOWED:
                createResponse(ctx, "METHOD_NOT_ALLOWED");
                break;
            case FORBIDDEN:
                createResponse(ctx, "FORBIDDEN");
                break;
            case NOT_FOUND:
                createResponse(ctx, "Not_FOUND");
                break;
            default:
                break;
        }

    }


    private void createResponse(ChannelHandlerContext ctx, String info) {
        DefaultFullHttpResponse dsrespone = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1,OK);
        dsrespone.headers().set("Content-type","text/html;charset=UTF-8");
        ByteBuf buf = Unpooled.copiedBuffer(info, CharsetUtil.UTF_8);
        dsrespone.content().writeBytes(buf);
        buf.release();
        ctx.writeAndFlush(dsrespone).addListener(ChannelFutureListener.CLOSE);
    }


    private void sendFileToClient(ChannelHandlerContext ctx, File file, String uri) throws Exception {
        ByteBuf buffer=Unpooled.copiedBuffer(Files.readAllBytes(file.toPath()));
        FullHttpResponse resp=new DefaultFullHttpResponse(HttpVersion.HTTP_1_1,HttpResponseStatus.OK,buffer);
        MimetypesFileTypeMap mimeTypeMap=new MimetypesFileTypeMap();
        resp.headers().set("Content-type", mimeTypeMap.getContentType(file));
        ctx.writeAndFlush(resp).addListener(ChannelFutureListener.CLOSE);
    }




}
