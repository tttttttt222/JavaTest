package com.test.designpatterns.observerpattern.callback;


/**
 * 项目名称:testProject 描述: 创建人:ryw 创建时间:2018/9/11
 */
public class A {

    private CallBack callback;
    //注册一个事件
    public void register(CallBack callback){
        this.callback = callback;
    }
    // 需要调用的时候回调
    public void call(){
        callback.oncall();
    }


}
