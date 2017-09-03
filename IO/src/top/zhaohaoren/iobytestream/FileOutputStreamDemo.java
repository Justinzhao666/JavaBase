/*
 * Copyright (c) 2017/9/2 by zhaohaoren
 * Welcome to visit my site:
 *  
 *  www.zhaohaoren.top
 *
 * @ Project: JavaBase
 * @ Lan: Java
 * @ author zhaohaoren
 * @ version 1.0 
 * FileOutputStreamDemo Create on 2017/9/2
 */
package top.zhaohaoren.iobytestream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * FileOutputStream
 * 指定输出对象，写入数据！
 *
 * # 字节流不适合操作中文 #
 * 字节流读取中文会有乱码问题，因为一个中文是两个字节，一个标点符号是一个字节，这样如果按照字节流读取
 * 会容易发生中文2个字节只先被读取一半的情况。
 * 并且，字节流只能read或者write字节数组！
 */
public class FileOutputStreamDemo {
    public static void main(String[] agrs) throws IOException {

        // 创建输出流的对象，如果没有会自动创建文件。如果不加true的话，new FileOutputStream()这句话就会将文件清空！
        // 加上true是指将流的管道口指定到文件的末尾处，而不是开头。
        FileOutputStream fos = new FileOutputStream("fos.txt", true); //不加true写入文件会覆盖原文本！
        fos.write(97); //写入会将int的前3个字节0去掉
        fos.write(99);
        fos.write(98);
        fos.close();
        writeChinese();
    }


    /**
     * 字节流操作中文
     */
    public static void writeChinese() throws IOException {

        FileInputStream fis = new FileInputStream("zhaohaoren.txt");

        int content;
        byte[] bytes = new byte[2];
        while ((content = fis.read(bytes)) != -1) {
            //new String(byte[],偏移地址，偏移量)将byte转为中文字符
            System.out.println(new String(bytes,0,content));
        }
        fis.close();

    }

}
