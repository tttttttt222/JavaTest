package com.test.nio.server;

import com.test.nio.server.MultipTimeServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 项目名称:JavaTest
 * 描述:
 * 创建人:ryw
 * 创建时间:2017/6/21
 */
public class NioChannelServer {


    public static void main(String args[]) throws Exception {
        int port = 8089;
        MultipTimeServer timeServer = new MultipTimeServer(port);
        new Thread(timeServer, "NIO-thread").start();
    }

    /*普通socket*/
    public void sockettest() throws Exception {
        ServerSocket serverSocket = new ServerSocket(8090);
        while (true) {
            Socket socket = null;
            socket = serverSocket.accept();
            System.out.println("New connection accepted " +
                    socket.getInetAddress() + ":" + socket.getPort());
            InputStream inputStream = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String s = br.readLine();
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.write("123");
        }


    }

}
