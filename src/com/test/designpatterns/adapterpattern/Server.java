package com.test.designpatterns.adapterpattern;

/**
 * 项目名称:testProject 描述: 创建人:ryw 创建时间:2018/9/6
 */
public class Server extends Adapter {
    @Override
    public void SSH(){ System.out.println("Connect success!"); };

    @Override
    public void NET(){ System.out.println("Hello WWW!"); };

    @Override
    public void Tomcat(){ System.out.println("Tomcat 9 is running!"); };

    @Override
    public void Mysql(){ System.out.println("Mysql is running!"); };
}
