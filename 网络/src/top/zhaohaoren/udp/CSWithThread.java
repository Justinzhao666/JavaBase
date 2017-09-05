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
 * CSWithThread Create on 2017/9/5
 */
package top.zhaohaoren.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * 使用多线程将发送和接收放在一个程序中运行
 */
public class CSWithThread {
    public static void main(String[] args) {
        new Receiver().start();
        new Sender().start();
    }
}

class Sender extends Thread {
    @Override
    public void run() {
        try {
            Scanner scanner = new Scanner(System.in);
            DatagramSocket ds = new DatagramSocket();

            while (true) {
                String content = scanner.nextLine();
                if (content.equals("exit")) {
                    break;
                }
                DatagramPacket dp = new DatagramPacket(content.getBytes(), content.getBytes().length, InetAddress.getByName("127.0.0.1"), 6666);
                ds.send(dp);
            }
            ds.close();
            scanner.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}

class Receiver extends Thread {
    @Override
    public void run() {
        try {
            DatagramSocket ds = new DatagramSocket(6666);
            DatagramPacket dp = new DatagramPacket(new byte[1024], 1024);
            while (true) {
                ds.receive(dp);
                byte[] content = dp.getData();
                int len = dp.getLength();
                String ip = dp.getAddress().getHostAddress();
                Integer port = dp.getPort();
                System.out.println(ip + " : " + port + " : " + new String(content, 0, len));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}