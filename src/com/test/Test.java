package com.test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    public static void main(String[] args) throws ParseException {
//        call();
//        testInstance();
//        boolean contains = "余额不足".contains("");
//        int contains = "余额不足".indexOf("");
////        int contains = "".indexOf("余额不足");
//        System.out.println(contains);
//
//        Map<String,String> map = new HashMap<>();
//        Set<Entry<String, String>> entries = map.entrySet();
//
//        map.forEach((k,v)->System.out.println("Item : " + k + " Count : " + v));


//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH");

//        System.out.println(df.format(new Date()).equals("2018-09-30 15"));
//
//        Date date = new Date();
//
//        Date dt1 = df.parse("2018-09-30 16");
//
//        System.out.println(date.getTime() > dt1.getTime());

        BigDecimal balance = new BigDecimal(100);
        String amount = "400000000";

        BigDecimal subtract = new BigDecimal(amount).subtract(balance);
        double value = new BigDecimal(amount).subtract(balance).doubleValue();

        System.out.println(subtract.toString());
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
