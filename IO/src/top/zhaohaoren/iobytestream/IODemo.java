package top.zhaohaoren.iobytestream;/*
 * Copyright (c) 2017/9/2 by zhaohaoren
 * Welcome to visit my site:
 *  
 *  www.zhaohaoren.top
 *
 * @ Project: JavaBase
 * @ Lan: Java
 * @ author zhaohaoren
 * @ version 1.0 
 * top.zhaohaoren.iobytestream.IODemo Create on 2017/9/2
 */

/**
 *  IO流：
 *  Java中对数据的操作都是通过流的方式
 *  两种流向： 输入流 输出流
 *  流的操作类型分为：
 *      字符流：只能操作纯字符数据
 *      字节流：可以操作任何数据，计算机任何数据都是以字节方式存储的
 *
 *  IO流父类：（都是抽象类）
 *  字节流：
 *      InputStream
 *      OutputStream
 *  字符流
 *      Writer
 *      Reader
 *
 *  read方法，一次可以读取文件中的一个字节，或者指定缓冲区大小的字节数。---多使用缓冲区，减少IO次数，减少硬盘消耗
 *
 *  使用IO流的最后需要关闭资源：因为IO流相当于在内存和磁盘之间建立一个管道，读写完成了需要关闭这个管道！
 *
 *
 */
public class IODemo {
    public static void main(String[] agrs) {

    }
}
