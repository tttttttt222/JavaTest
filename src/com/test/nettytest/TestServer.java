package com.test.nettytest;

import java.io.*;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 项目名称:testProject
 * 描述:
 * 创建人:ryw
 * 创建时间:2018/3/8
 */
public class TestServer {


    public static void main(String[] args) throws IOException, InterruptedException {
//        Thread thread = new Thread();
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor();
//        threadPoolExecutor.execute();
//        thread.join();
        System.out.println(Runtime.getRuntime().maxMemory() + "   "+ Runtime.getRuntime().totalMemory() );

//        String comd = "D:\\APP\\BaiduNetdisk\\BaiduNetdisk.exe";
        String comd = "netstat -nao";
        Process exec = Runtime.getRuntime().exec(comd);
        InputStream fis=exec.getInputStream();
        //用一个读输出流类去读
        InputStreamReader isr=new InputStreamReader(fis,"GBK");
        //用缓冲器读行
        BufferedReader br=new BufferedReader(isr);
        String line=null;
        //直到读完为止
        while((line=br.readLine())!=null)
        {
            System.out.println(line);
        }
        exec.waitFor();
    }

}
