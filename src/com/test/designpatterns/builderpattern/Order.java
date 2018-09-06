package com.test.designpatterns.builderpattern;

/**
 * 项目名称:testProject 描述: 创建人:ryw 创建时间:2018/9/4
 */
public class Order {

    private Burger burger;
    private Suit suit;

    public Burger getBurger() {
        return burger;
    }

    public void setBurger(Burger burger) {
        this.burger = burger;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }
}
