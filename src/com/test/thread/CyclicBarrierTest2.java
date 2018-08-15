package com.test.thread;

import java.util.concurrent.CyclicBarrier;

/**
 * 项目名称:testProject
 * 描述:所有线程写入操作完之后，进行额外的其他操作可以为CyclicBarrier提供Runnable参数
 * 创建人:ryw
 * 创建时间:2018/7/19
 */
public class CyclicBarrierTest2 {


    public static void main(String[] args) {
        int N = 4;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(N, new Runnable() {
            @Override
            public void run() {
                System.out.println("当前线程"+Thread.currentThread().getName());
            }
        });


        for (int i = 0; i < N; i++) {
            new Cyct(cyclicBarrier,1000*i).start();
        }


    }


    static class Cyct extends Thread {

        //每个写入线程执行完写数据操作之后，就在等待其他线程写入操作完毕。
        //当所有线程线程写入操作完毕之后，所有线程就继续进行后续的操作了
        private CyclicBarrier cyclicBarrier;

        private int time;

        public Cyct(CyclicBarrier cyclicBarrier, int time) {
            this.cyclicBarrier = cyclicBarrier;
            this.time = time;
        }


        @Override
        public void run() {
            try {
                long l = System.currentTimeMillis();
                System.out.println("线程" + Thread.currentThread().getName() + "正在写入数据..." + time);
                Thread.sleep(time);
                System.out.println("线程" + Thread.currentThread().getName() + "写入数据完毕，等待其他线程写入完毕" + (System.currentTimeMillis() - l));
                cyclicBarrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("所有线程写入完毕，继续处理其他任务...");
        }

    }


    




}
