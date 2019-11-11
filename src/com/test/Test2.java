package com.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 项目名称:testProject 描述: 创建人:ryw 创建时间:2018/11/23
 */
public class Test2 {

    public void say() {
        System.out.println("Say Hello");
    }


    public static void main(String[] args) throws ParseException {
        String s ="08:00:00";
        String s1 = "17:00:00";
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        Date now = new Date();
        Date parse = df.parse(df2.format(now) + " " + s);
        Date parse1 = df.parse(df2.format(now) + " " + s1);
        if( now.getTime() >= parse.getTime() &&  now.getTime() < parse1.getTime()){
            System.out.println(true);
        }

        if( now.getTime() >= parse1.getTime()  ||  now.getTime() < parse.getTime()){
            System.out.println(true);
        }
    }


}
