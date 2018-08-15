package com.test.thread;



import java.util.concurrent.*;


/**
 * 项目名称:JavaTest
 * 描述:
 * 创建人:ryw
 * 创建时间:2017/7/6
 */
public class CallableTest {



    public static  void main(String args[]) throws Exception{
        ExecutorService mExecutor = Executors.newCachedThreadPool();
        Future<String> future = mExecutor.submit(new Callable<String>() {

            @Override
            public String call() throws Exception {
                Thread.sleep(3000);
                System.out.println(Thread.currentThread().getName());

                //int a=1/0;

                return "123";
            }
        });

        System.out.println("线程前");

        System.out.println(Thread.currentThread().getName());

//        String s = future.get();
        String s = future.get(1, TimeUnit.SECONDS);
        System.out.println("线程执行完毕");
        System.out.println("结果:"+s);
        System.out.println(Thread.currentThread().getName());


        boolean cancel = future.cancel(true);
        boolean done = future.isDone();
        System.out.println(cancel+"-------"+done);


       /* public Future submit() {
            final Future future = new Future();

            new Thread() {
                public void run() {
                    future.call();
                    future.setRealres(res);
                }
            }.start();

            return future;
        }*/

       //AbstractExecutorService
       //FutureTask

    }




}

