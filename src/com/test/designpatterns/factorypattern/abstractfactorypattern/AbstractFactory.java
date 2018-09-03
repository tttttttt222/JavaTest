package com.test.designpatterns.factorypattern.abstractfactorypattern;

import com.test.designpatterns.factorypattern.Color;
import com.test.designpatterns.factorypattern.Shape;

/**
 * 项目名称:testProject 描述: 创建人:ryw 创建时间:2018/9/3
 */
public abstract  class AbstractFactory {

    public abstract Color getColor(String color);
    public abstract Shape getShape(String shape) ;

}
