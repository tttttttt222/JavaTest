package com.test.designpatterns.decoratorpattern;

/**
 * 项目名称:testProject 描述: 创建人:ryw 创建时间:2018/9/7
 */
public class DecoratorPatternDemo {

    public static void main(String[] args) {

        Shape redCircle = new ShapeDecorator(new Circle());

        Shape redRectangle = new ShapeDecorator(new Rectangle());

        redCircle.draw();

        redRectangle.draw();
    }



}
