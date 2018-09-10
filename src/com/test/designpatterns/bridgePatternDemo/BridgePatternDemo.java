package com.test.designpatterns.bridgePatternDemo;

/**
 * 项目名称:testProject 描述: 创建人:ryw 创建时间:2018/9/7
 */
public class BridgePatternDemo {

    public static void main(String[] args) {
        Shape redCircle = new Circle(100, 100, 10, new RedCircle());
        Shape greenCircle = new Circle(100, 100, 10, new GreenCircle());

        redCircle.draw();
        greenCircle.draw();
    }

}
