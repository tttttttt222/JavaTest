package com.test.designpatterns.factorypattern.normalfactory;

import com.test.designpatterns.factorypattern.Shape;
import com.test.designpatterns.factorypattern.Square;

/**
 * 项目名称:testProject 描述: 创建人:ryw 创建时间:2018/8/31
 */
public class NormalShapeSquareFactoryImpl implements NormalShapeFactory {


    @Override
    public Shape getShape() {
        return new Square();
    }

}
