/*
 * Copyright (c) 2017/11/2 by zhaohaoren
 * Welcome to visit my site:
 *  
 *  www.zhaohaoren.top
 *
 * @ Project: JavaCode
 * @ Lan: Java
 * @ author zhaohaoren
 * @ version 1.0 
 * J01ChannelDemo Create on 2017/11/2
 */
package top.zhaohaoren.NIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 四种channel：
     FileChannel 从文件中读写数据。
     DatagramChannel 能通过UDP读写网络中的数据。
     SocketChannel 能通过TCP读写网络中的数据。
     ServerSocketChannel可以监听新进来的TCP连接，像Web服务器那样。对每一个新进来的连接都会创建一个SocketChannel。
 */
public class J01ChannelDemo {
    public static void main(String[] args) throws IOException {

        File f = new File("data.txt");
        System.out.println(f.exists());

        RandomAccessFile aFile = new RandomAccessFile("data.txt","rw");
        FileChannel inChannel = aFile.getChannel();

        // 创建一个48字节的buffer
        ByteBuffer buf = ByteBuffer.allocate(48);

        //将文件读入到buffer中   ---写buffer
        int byteRead = inChannel.read(buf);

        while (byteRead !=-1){
            System.out.println("READ "+ byteRead);

            //将buffer由 写模式转为读模式
            buf.flip();

            while(buf.hasRemaining()){
                System.out.print((char) buf.get()); // 读取buffer内容，一次读取一个字节
            }

            buf.clear(); // 读取完毕后，清空buffer中的内容，继续读取文件内容写入buffer中。
            byteRead = inChannel.read(buf);
        }

        aFile.close();

    }
}
