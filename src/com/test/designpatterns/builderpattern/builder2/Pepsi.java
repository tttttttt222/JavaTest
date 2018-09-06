package com.test.designpatterns.builderpattern.builder2;

/**
 * 项目名称:testProject 描述: 创建人:ryw 创建时间:2018/9/5
 */
public class Pepsi extends ColdDrink {

    @Override
    public float price() {
        return 35.0f;
    }

    @Override
    public String name() {
        return "Pepsi";
    }

}
