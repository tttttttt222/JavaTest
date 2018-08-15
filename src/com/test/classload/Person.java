package com.test.classload;

/**
 * 项目名称:testProject
 * 描述:
 * 创建人:ryw
 * 创建时间:2018/3/6
 */
public class Person {

//    private int a =1;

//    public static final String s ="aaa";

    public void sayHello(){
        System.out.println("hello world！");
        sayHello();
    }
}
