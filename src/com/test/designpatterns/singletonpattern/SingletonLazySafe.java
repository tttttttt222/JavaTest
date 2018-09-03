package com.test.designpatterns.singletonpattern;

/**
 * 项目名称:testProject 描述: 创建人:ryw 创建时间:2018/9/3
 */
public class SingletonLazySafe {

    private static SingletonLazySafe instance;
    private SingletonLazySafe (){}
    public static synchronized SingletonLazySafe getInstance() {
        if (instance == null) {
            instance = new SingletonLazySafe();
        }
        return instance;
    }

}
