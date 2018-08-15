package com.test.asm.aop;

import java.lang.reflect.Method;

/**
 * 项目名称:testProject
 * 描述:
 * 创建人:ryw
 * 创建时间:2018/3/28
 */
public class Test {

    public static void main(String[] args) throws Exception {
        AopClassLoader aopClassLoader = new AopClassLoader();
        Class<?> clazz = aopClassLoader.loadClass("TestBean_Tmp");
        Method halloAop = clazz.getMethod("halloAop", null);
        String canonicalName = clazz.getCanonicalName();
        Object o = clazz.newInstance();
        halloAop.invoke(o,null);
    }
}
