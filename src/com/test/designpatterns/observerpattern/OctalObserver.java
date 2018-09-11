package com.test.designpatterns.observerpattern;

/**
 * 项目名称:testProject 描述: 创建人:ryw 创建时间:2018/9/11
 */
public class OctalObserver extends Observer {

    public OctalObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "Octal String: "
                + Integer.toOctalString( subject.getState() ) );
    }

}
