package com.test.designpatterns.singletonpattern;

/**
 * 而这种方式是 Singleton 类被装载了，instance 不一定被初始化。因为 SingletonHolder 类没有被主动使用，只有通过显式调用 getInstance 方法时，才会显式装载 SingletonHolder 类，从而实例化 instance
 * 项目名称:testProject 描述: 创建人:ryw 创建时间:2018/9/3
 */
public class Singleton3 {

    private static class SingletonHolder {

        private static final Singleton3 INSTANCE = new Singleton3();
    }


    private Singleton3() {
    }

    public static final Singleton3 getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
