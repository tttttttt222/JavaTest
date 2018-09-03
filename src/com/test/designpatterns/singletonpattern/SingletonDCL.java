package com.test.designpatterns.singletonpattern;

/**
 * 这种方式采用双锁机制，安全且在多线程情况下能保持高性能
 * 项目名称:testProject 描述: 创建人:ryw 创建时间:2018/9/3
 */
public class SingletonDCL {

    private volatile static SingletonDCL singleton;

    private SingletonDCL() {
    }

    public static SingletonDCL getSingleton() {
        if (singleton == null) {
            synchronized (SingletonDCL.class) {
                if (singleton == null) {
                    singleton = new SingletonDCL();
                }
            }
        }
        return singleton;
    }
}
