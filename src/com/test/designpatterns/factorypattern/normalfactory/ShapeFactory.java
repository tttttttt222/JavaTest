package com.test.designpatterns.factorypattern.normalfactory;

import com.test.designpatterns.factorypattern.Circle;
import com.test.designpatterns.factorypattern.Shape;
import com.test.designpatterns.factorypattern.Square;

/**
 * 项目名称:testProject 描述: 创建人:ryw 创建时间:2018/8/31
 */
public class ShapeFactory {





    //使用 getShape 方法获取形状类型的对象
    public Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        } else if (shapeType.equalsIgnoreCase("SQUARE")) {
            return new Square();
        }
        return null;
    }
}
