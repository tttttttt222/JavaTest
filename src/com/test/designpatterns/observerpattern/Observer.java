package com.test.designpatterns.observerpattern;

/**
 * 项目名称:testProject 描述: 创建人:ryw 创建时间:2018/9/11
 */
public abstract class Observer {

    protected Subject subject;
    public abstract void update();

}
