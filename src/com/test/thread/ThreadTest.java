package com.test.thread;

import java.util.concurrent.*;
import java.util.concurrent.Callable;

/**
 * 项目名称:JavaTest
 * 描述:
 * 创建人:ryw
 * 创建时间:2017/7/7
 */
public class ThreadTest {
    public static  void main(String args[]) throws Exception{
        Thread t1=new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(3000);
                            System.out.println("线程"+Thread.currentThread().getName());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
        t1.start();
        System.out.println("join前线程"+Thread.currentThread().getName());
        //t1.join(100);
        t1.join();


        System.out.println("join后线程"+Thread.currentThread().getName());

    }
}
