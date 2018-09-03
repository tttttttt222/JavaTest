package com.test.designpatterns.factorypattern.abstractfactorypattern;

import com.test.designpatterns.factorypattern.Circle;
import com.test.designpatterns.factorypattern.Color;
import com.test.designpatterns.factorypattern.Rectangle;
import com.test.designpatterns.factorypattern.Shape;
import com.test.designpatterns.factorypattern.Square;

/**
 * 项目名称:testProject 描述: 创建人:ryw 创建时间:2018/9/3
 */
public class ShapeFactory extends AbstractFactory {

    @Override
    public Shape getShape(String shapeType){
        if(shapeType == null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        } else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }
        return null;
    }

    @Override
    public Color getColor(String color) {
        return null;
    }

}
