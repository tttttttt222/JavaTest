package com.test.designpatterns.observerpattern.callback;

/**
 * 项目名称:testProject 描述: 创建人:ryw 创建时间:2018/9/11
 */
public class CallBackDemo {


    public static void main(String[] args) {
        A a = new A();

        a.register(new CallBack() {
            @Override
            public void oncall() {
                System.out.println("回调函数被调用");
            }
        });

        a.call();

    }

}
