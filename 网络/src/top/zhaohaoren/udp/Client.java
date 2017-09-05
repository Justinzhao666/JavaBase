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
package top.zhaohaoren.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 *  接收方
 *  DatagramSocket： 负责接收6666端口的数据的socket
 *  DatagramPacket： 本地缓冲区，接收socket传递来的数据
 */
public class Client {
    public static void main(String[] args) throws IOException {


        DatagramSocket ds = new DatagramSocket(6666);
        DatagramPacket dp = new DatagramPacket(new byte[1024],1024);

        while (true){
            ds.receive(dp);
            byte[] content = dp.getData();
            int len = dp.getLength();
            String ip = dp.getAddress().getHostAddress();
            Integer port = dp.getPort();
            System.out.println(ip+ " : "+port+" : "+new String(content,0,len));
        }


    }
}
