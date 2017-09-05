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
package top.zhaohaoren.udp;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 *  UDP发送端
 *  DatagramSocket  负责发送的套接字
 *  DatagramPacket  被发送的数据包
 */
public class Server {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        DatagramSocket ds = new DatagramSocket();


        while (true){
            String content = scanner.nextLine();
            if (content.equals("exit")){
                break;
            }
            DatagramPacket dp = new DatagramPacket(content.getBytes(),content.getBytes().length, InetAddress.getByName("127.0.0.1"),6666);
            ds.send(dp);
        }

        ds.close();
        scanner.close();

    }
}
