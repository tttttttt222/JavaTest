package com.test.designpatterns.builderpattern;

import com.test.designpatterns.builderpattern.Burger;
import com.test.designpatterns.builderpattern.Order;
import com.test.designpatterns.builderpattern.OrderBuilder;
import com.test.designpatterns.builderpattern.Suit;

/**
 * 项目名称:testProject 描述: 创建人:ryw 创建时间:2018/9/5
 */
public class BuilderDemo {

    public static void main(String[] args) {
        Order build = new OrderBuilder().burger(new Burger()).suit(new Suit()).build();
    }

}
