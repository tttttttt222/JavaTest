package com.test.designpatterns.bridgePatternDemo;

/**
 * 项目名称:testProject 描述: 创建人:ryw 创建时间:2018/9/7
 */
public class RedCircle implements DrawAPI {


    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: red, radius: "
                + radius +", x: " +x+", "+ y +"]");
    }
}
