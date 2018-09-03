package com.test.designpatterns.factorypattern.normalfactory;

/**
 * 项目名称:testProject 描述: 创建人:ryw 创建时间:2018/8/31
 */
public class FactoryPatternDemo {

    public static void main(String[] args) {
        NormalShapeFactory shapeCircleFactory = new NormalShapeCircleFactoryImpl();
        NormalShapeFactory shapeSquareFactory = new NormalShapeSquareFactoryImpl();

        shapeCircleFactory.getShape().draw();
        shapeSquareFactory.getShape().draw();
    }
}
