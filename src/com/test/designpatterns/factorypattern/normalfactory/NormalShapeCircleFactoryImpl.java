package com.test.designpatterns.factorypattern.normalfactory;

import com.test.designpatterns.factorypattern.Circle;
import com.test.designpatterns.factorypattern.Shape;

/**
 * 项目名称:testProject 描述: 创建人:ryw 创建时间:2018/8/31
 */
public class NormalShapeCircleFactoryImpl implements NormalShapeFactory {


    @Override
    public Shape getShape() {
        return new Circle();
    }

}
