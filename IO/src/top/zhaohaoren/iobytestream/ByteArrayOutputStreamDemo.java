/*
 * Copyright (c) 2017/9/3 by zhaohaoren
 * Welcome to visit my site:
 *  
 *  www.zhaohaoren.top
 *
 * @ Project: JavaCode
 * @ Lan: Java
 * @ author zhaohaoren
 * @ version 1.0 
 * ByteArrayOutputStream Create on 2017/9/3
 */
package top.zhaohaoren.iobytestream;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 *  内存输入流： 指的是该流的作用将读取到的数据全部存入内存中，不需要关闭流（从内存写入内存的操作）
 *  ByteArrayOutputStream
 *
 *  原理：ByteArrayOutputStream内部再内存中有一个缓冲区，这个缓冲区依据存入的数据自动增长。
 *  该流的意义就是在内存中创建一块缓存区，将所有的读入的数据都输出到缓冲中去。
 *
 *  好处：使用的是字节流，可以保证所有字节录入完成后转换为字符，这样中文等多个字节显示一个字符的文字不会乱码。
 *  坏处：占内存。
 *
 *  方法
 *  write： 和其他流一样，写入数据用write
 *  toString： 将内部的byte数组全部转换为String，只能使用平台默认编码，windows是jbk
 *  toByteArray：将内存中的byte数组拷贝一份
 *
 */
public class ByteArrayOutputStreamDemo {
    public static void main(String[] args) throws IOException {

        FileInputStream fis = new FileInputStream("zhaohaoren.txt");
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        int content;
        while ((content = fis.read()) != -1){
            bos.write(content);  //将所有的read内容全部存入该流对象内部的数组中去。
        }

        // 通过字节流来读入和写入，但是想要显示字符：
        //方法1： 使用byte数组转string。好处： 可以指定编码
        byte[] arrs = bos.toByteArray();
        System.out.println(new String(arrs));

        //方法2： 直接使用提供的toString方法将内不的byte数组转为String。利弊：不可以指定编码，但是方便
        System.out.println(bos.toString());
//        bos.close(); 该流并不需要关闭，因为他没有IO资源消耗，只是内存中的操作。
        fis.close();


    }
}
