package com.test.designpatterns.observerpattern;

/**
 * 项目名称:testProject 描述: 创建人:ryw 创建时间:2018/9/11
 */
public class HexaObserver extends Observer {

    public HexaObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "Hex String: "
                + Integer.toHexString( subject.getState() ).toUpperCase() );
    }

}
