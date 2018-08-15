package com.test.thread;

import javax.xml.crypto.Data;
import java.util.concurrent.CyclicBarrier;

/**
 * 项目名称:testProject
 * 描述:比较常用，用来挂起当前线程，直至所有线程都到达barrier状态再同时执行后续任务；
 * 创建人:ryw
 * 创建时间:2018/7/19
 */
public class CyclicBarrierTest {


    public static void main(String[] args) {
        int N = 4;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(N);


        for (int i = 0; i < N; i++) {
            new Cyct(cyclicBarrier, 1000 * i).start();
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
