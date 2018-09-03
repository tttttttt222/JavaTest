package com.test.designpatterns.factorypattern.abstractfactorypattern;

import com.test.designpatterns.factorypattern.Blue;
import com.test.designpatterns.factorypattern.Color;
import com.test.designpatterns.factorypattern.Green;
import com.test.designpatterns.factorypattern.Red;
import com.test.designpatterns.factorypattern.Shape;

/**
 * 项目名称:testProject 描述: 创建人:ryw 创建时间:2018/9/3
 */
public class ColorFactory extends AbstractFactory  {
    @Override
    public Shape getShape(String shapeType){
        return null;
    }

    @Override
    public Color getColor(String color) {
        if(color == null){
            return null;
        }
        if(color.equalsIgnoreCase("RED")){
            return new Red();
        } else if(color.equalsIgnoreCase("GREEN")){
            return new Green();
        } else if(color.equalsIgnoreCase("BLUE")){
            return new Blue();
        }
        return null;
    }
}
