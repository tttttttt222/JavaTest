package com.test.designpatterns.factorypattern.simplenormalfactory;

import com.test.designpatterns.factorypattern.Shape;

/**
 * 项目名称:testProject 描述: 创建人:ryw 创建时间:2018/8/31
 */
public class SimpleFactoryPatternDemo {

    public static void main(String[] args) {
        SimpleShapeFactory shapeFactory = new SimpleShapeFactory();

        //获取 Circle 的对象，并调用它的 draw 方法
        Shape shape1 = shapeFactory.getShape("CIRCLE");

        //调用 Circle 的 draw 方法
        shape1.draw();

        //获取 Rectangle 的对象，并调用它的 draw 方法
        Shape shape2 = shapeFactory.getShape("RECTANGLE");

        //调用 Rectangle 的 draw 方法
        shape2.draw();

        //获取 Square 的对象，并调用它的 draw 方法
        Shape shape3 = shapeFactory.getShape("SQUARE");

        //调用 Square 的 draw 方法
        shape3.draw();
    }
}
