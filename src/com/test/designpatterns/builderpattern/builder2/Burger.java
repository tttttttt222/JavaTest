package com.test.designpatterns.builderpattern.builder2;

/**
 * 项目名称:testProject 描述: 创建人:ryw 创建时间:2018/9/5
 */
public abstract class Burger implements Item {

    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price();

}
