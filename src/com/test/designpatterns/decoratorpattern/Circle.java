package com.test.designpatterns.decoratorpattern;

/**
 * 项目名称:testProject 描述: 创建人:ryw 创建时间:2018/9/7
 */
public class Circle  implements Shape {

    @Override
    public void draw() {
        System.out.println("Shape: Circle");
    }
}
