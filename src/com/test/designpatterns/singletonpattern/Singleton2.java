package com.test.designpatterns.singletonpattern;

/**
 * 项目名称:testProject 描述: 创建人:ryw 创建时间:2018/9/3
 */
public class Singleton2 {

    private static Singleton2 instance = new Singleton2();

    private Singleton2() {
    }

    public static Singleton2 getInstance() {
        return instance;
    }

}
