package com.test.designpatterns.decoratorpattern;

/**
 * 项目名称:testProject 描述: 创建人:ryw 创建时间:2018/9/7
 */
public  class ShapeDecorator implements Shape {
    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape){
        this.decoratedShape = decoratedShape;
    }

    public void draw(){
        System.out.println("--------------------");
        decoratedShape.draw();
        System.out.println("--------------------");
    }

}
