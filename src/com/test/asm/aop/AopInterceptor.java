package com.test.asm.aop;

/**
 * 项目名称:testProject
 * 描述:
 * 创建人:ryw
 * 创建时间:2018/3/22
 */
public class AopInterceptor {


    public static void beforeInvoke(){
        System.out.println("before");
    }

    public static void afterInvoke(){
        System.out.println("after");
    }

}
