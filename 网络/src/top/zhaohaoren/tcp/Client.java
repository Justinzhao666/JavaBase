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
 * Client Create on 2017/9/5
 */
package top.zhaohaoren.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 *  客户端：
 *  只需要 建立Socket对象，通过socket对象控制网络间的IO的输入输出流InputStream，OutputStream。
 *
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket(InetAddress.getByName("127.0.0.1"),6666);
        InputStream is = s.getInputStream();
        OutputStream os = s.getOutputStream();

        os.write("i am client".getBytes());

        byte[] message = new byte[1024];
        int len = is.read(message);
        System.out.println(new String(message,0,len));
        s.close();
        is.close();
        os.close();
    }
}
