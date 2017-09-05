/*
 * Copyright (c) 2017/9/5 by zhaohaoren
 * Welcome to visit my site:
 *  
 *  www.zhaohaoren.top
 *
 * @ Project: JavaCode
 * @ Lan: Java
 * @ author zhaohaoren
 * @ version 1.0 
 * Server Create on 2017/9/5
 */
package top.zhaohaoren.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *  服务器端：
 *  1. 首先需要创建 ServerSocket 对象，开启后会一直监听端口，等待客户端的Socket对象连接。
 *  2. 当有客户端连接成功时，会返回一个Socket对象，通过该socket对象控制网络IO和客户端进行交互
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(6666);
        Socket s = ss.accept(); // 接受客户端的请求
        InputStream is = s.getInputStream();  //获取服务器输入流：客户端发给服务器的数据
        OutputStream os = s.getOutputStream(); //获取服务器输出流：服务器要发给客户端的数据

        os.write("i am server".getBytes());  // 发送数据给客户端

        byte[] message = new byte[1024];
        int len = is.read(message);
        System.out.println(new String(message,0,len));
    }
}
