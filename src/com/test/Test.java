package com.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.BiConsumer;

/**
 * 项目名称:testProject
 * 描述:
 * 创建人:ryw
 * 创建时间:2018/2/22
 */
public class Test {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
//        call();
//        testInstance();
//        boolean contains = "余额不足".contains("");
        int contains = "余额不足".indexOf("");
//        int contains = "".indexOf("余额不足");
        System.out.println(contains);

        Map<String,String> map = new HashMap<>();
        Set<Entry<String, String>> entries = map.entrySet();

        map.forEach((k,v)->System.out.println("Item : " + k + " Count : " + v));
    }

    private static void call() {
        int a = 0;
        byte[] a1, a2, a3, a4;
        while (true) {
            a1 = new byte[4 * _1MB];
            a2 = new byte[2 * _1MB];
            a3 = new byte[2 * _1MB];
            a4 = new byte[2 * _1MB];
        }
//        call();
    }


    interface A{
        void say();
    }

    static class B implements A{

        @Override
        public void say() {
            System.out.println("A");
        }
    }

    private static void testInstance(){

        B b = new B();
        System.out.println(b instanceof A);
    }




}
