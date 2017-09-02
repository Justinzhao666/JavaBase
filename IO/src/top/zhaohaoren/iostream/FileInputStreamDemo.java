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
 * FileInputStreamDemo Create on 2017/9/2
 */
package top.zhaohaoren.iostream;

import java.io.FileInputStream;
import java.io.IOException;


/**
 * FileInputStream
 * 搭建文件和内存的流管道
 * read() 返回值int，每次从管道中读取一个字节，文件若结束返回-1，返回的是读取的那个字节的int型数值
 * read(byte[])  返回值int，每次从管道中读取byte[]数组大小个字节数据存入到byte[]数组中，返回读到的字节个数
 *
 */
public class FileInputStreamDemo {
    public static void main(String[] agrs) throws IOException {

        FileInputStream fis = new FileInputStream("zhaohaoren.txt");
//        System.out.println(fis.read());
//        System.out.println(fis.read());
//        System.out.println(fis.read());
//        System.out.println(fis.read());
//        System.out.println(fis.read());
        int content;
        /*
        * 为什么read()返回int类型数据
        * 如果返回byte，因为read遇到-1就代表文件结束符，文件就不读了，而read是一个字节一个字节的读取任意文件，
        * 可能文件中某个字节刚好等于-1的补码，这样文件就意外中断了！
        * 所以保证可以准确读入文件中的字节，在读入一个字节前填入0
        * */
        while ((content = fis.read())!=-1){
            System.out.println(content);
        }
        fis.close();


    }
}
