package com.test.designpatterns.adapterpattern;

/**
 * 项目名称:testProject 描述: 创建人:ryw 创建时间:2018/9/6
 */
public class Chat extends Adapter {

    @Override
    public void NET(){ System.out.println("Hello world!"); };

    @Override
    public void FTP(){ System.out.println("File upload succeddful!"); };
}
