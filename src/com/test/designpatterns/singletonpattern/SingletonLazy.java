package com.test.designpatterns.singletonpattern;

/**
 * 懒汉式，线程不安全
 * 项目名称:testProject 描述: 创建人:ryw 创建时间:2018/9/3
 */
public class SingletonLazy {

    private static SingletonLazy instance;
    private SingletonLazy(){}

    public static SingletonLazy getInstance() {
        if (instance == null) {
            instance = new SingletonLazy();
        }
        return instance;
    }
}
