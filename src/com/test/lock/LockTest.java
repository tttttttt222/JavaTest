package com.test.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 项目名称:testProject
 * 描述:
 * 创建人:ryw
 * 创建时间:2018/4/12
 */
public class LockTest {

    private static ReentrantLock reentrantLock1 = new ReentrantLock();
    private static ReentrantLock reentrantLock2 = new ReentrantLock();

    public static void main(String[] args) {
          new Thread(new Runnable() {
              @Override
              public void run() {
                  System.out.println(Thread.currentThread().getName());
                  reentrantLock1.lock();
                  System.out.println("1"+Thread.currentThread().getName());
                  try {
                      Thread.sleep(10000);
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
                  reentrantLock2.lock();
                  System.out.println("2"+Thread.currentThread().getName());
                  reentrantLock2.unlock();
                  reentrantLock1.unlock();
              }
          }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                reentrantLock2.lock();
                System.out.println("2"+Thread.currentThread().getName());
                reentrantLock1.lock();
                System.out.println("1"+Thread.currentThread().getName());
                reentrantLock1.unlock();
                reentrantLock2.unlock();
            }
        }).start();
    }






}
