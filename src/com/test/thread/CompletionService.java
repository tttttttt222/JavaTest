package com.test.thread;


import java.util.concurrent.*;
import java.util.concurrent.Callable;;

/**
 * 项目名称:JavaTest
 * 描述:
 * 创建人:ryw
 * 创建时间:2017/7/6
 */
public class CompletionService {



    public static  void main(String args[]) throws Exception{
        ExecutorService threadPool = Executors.newCachedThreadPool();
        ExecutorCompletionService<Integer> cs = new ExecutorCompletionService<>(threadPool);
        for(int i = 1; i < 5; i++) {
            final int finalI = i;
            cs.submit(new Callable<Integer>() {
                   @Override
                   public Integer call() throws Exception {
                       Thread.sleep((4/finalI)*1000);
                       System.out.println(finalI+"----"+Thread.currentThread().getName());
                       return finalI;
                   }
               });
         }


        for(int i = 1; i < 5; i++) {
            try {
                System.out.println(cs.take().get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        //System.exit(1);

    }




}
