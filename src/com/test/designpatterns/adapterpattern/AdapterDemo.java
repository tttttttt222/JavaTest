package com.test.designpatterns.adapterpattern;

/**
 * 项目名称:testProject 描述: 创建人:ryw 创建时间:2018/9/6
 */
public class AdapterDemo {

    private static Port chatPort = new Chat();
    private static Port serverPort = new Server();

    public static void main(String[] args) {
        // 聊天服务
        chatPort.FTP();

        chatPort.NET();

        // 服务器
        serverPort.Mysql();

        serverPort.SSH();

        serverPort.Tomcat();

        serverPort.NET();
    }

}
