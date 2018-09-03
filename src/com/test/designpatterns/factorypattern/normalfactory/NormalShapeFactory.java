package com.test.designpatterns.factorypattern.normalfactory;

import com.test.designpatterns.factorypattern.Shape;

/**
 * 项目名称:testProject 描述: 创建人:ryw 创建时间:2018/9/3
 */
public interface NormalShapeFactory {

    //使用 getShape 方法获取形状类型的对象
    Shape getShape();
}
