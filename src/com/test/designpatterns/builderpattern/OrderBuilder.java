package com.test.designpatterns.builderpattern;

/**
 * 项目名称:testProject 描述: 创建人:ryw 创建时间:2018/9/4
 */
public class OrderBuilder {

    private Burger mBurger;
    private Suit mSuit;


    public OrderBuilder burger(Burger burger) {
        mBurger = burger;
        return this;
    }


    public OrderBuilder suit(Suit suit){
        mSuit = suit;
        return this;
    }


    public Order build(){
        Order order = new Order();
        order.setBurger(mBurger);
        order.setSuit(mSuit);
        return order;
    }

}
