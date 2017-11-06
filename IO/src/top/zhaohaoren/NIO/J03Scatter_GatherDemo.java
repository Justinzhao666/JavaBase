/*
 * Copyright (c) 2017/11/3 by zhaohaoren
 * Welcome to visit my site:
 *  
 *  www.zhaohaoren.top
 *
 * @ Project: JavaCode
 * @ Lan: Java
 * @ author zhaohaoren
 * @ version 1.0 
 * J03Scatter_GatherDemo Create on 2017/11/3
 */
package top.zhaohaoren.NIO;


import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 分散（scatter）从Channel中读取是指在读操作时将读取的数据写入多个buffer中。因此，Channel将从Channel中读取的数据“分散（scatter）”到多个Buffer中。
 * 聚集（gather）写入Channel是指在写操作时将多个buffer的数据写入同一个Channel，因此，Channel 将多个Buffer中的数据“聚集（gather）”后发送到Channel。
 */
public class J03Scatter_GatherDemo {
    public static void main(String[] args) throws IOException {

        RandomAccessFile aFile = new RandomAccessFile("./data.txt","rw");
        FileChannel channel = aFile.getChannel();


        //Scattering Reads : 数据从一个chanel读取到多个buffer中。 buffer是内存，所以叫读！
        ByteBuffer header = ByteBuffer.allocate(128);
        ByteBuffer body   = ByteBuffer.allocate(1024);
        ByteBuffer[] bufferArray = { header, body };
        channel.read(bufferArray);
        /*读入到buffer中，只有前面buffer填满了，才能移动到下一个buffer填*/


        //Gathering Writes ： 数据从多个buffer中写入到一个channel钟
        ByteBuffer header1 = ByteBuffer.allocate(128);
        ByteBuffer body1   = ByteBuffer.allocate(1024);
        ByteBuffer[] bufferArray1 = { header, body };
        channel.write(bufferArray1); // channel write是往channel中写！
        /*按照buffer的顺序，依次读取内容--position和limit之间的*/


    }
}
