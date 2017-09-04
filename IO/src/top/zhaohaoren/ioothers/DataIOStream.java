/*
 * Copyright (c) 2017/9/4 by zhaohaoren
 * Welcome to visit my site:
 *  
 *  www.zhaohaoren.top
 *
 * @ Project: JavaCode
 * @ Lan: Java
 * @ author zhaohaoren
 * @ version 1.0 
 * DataIOStream Create on 2017/9/4
 */
package top.zhaohaoren.ioothers;

import java.io.*;

/**
 *  数据输入输出流
 *  按照基本数据类型read和write
 *  属于字节流，但是他传输是依据你写入的数据类型的字节大小进行传入的。
 */
public class DataIOStream {
    public static void main(String[] args) throws IOException {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("zhaohaoren.txt"));
        // 这些都是对最基本的字节字符流进行装饰的类，需要传入字节和字符流
        dos.write(997);
        dos.write(998);
        dos.write(999);
        dos.close();

        /*
        * 如果是普通的字节流，传入997 大于一个字节 -127~128 那么他会取997int型4字节的最后一个字节，进行写入。
        * 如果这样，再次读取的时候997的大小前三个字节就丢失了，数据无法还原。
        * */
        DataInputStream dis =  new DataInputStream(new FileInputStream("zhaohaoren.txt"));
        System.out.println(dis.read());
        System.out.println(dis.read());
        System.out.println(dis.read());
        dis.close();
    }
}
