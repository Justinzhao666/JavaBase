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
 * FileStreamCopy Create on 2017/9/2
 */
package top.zhaohaoren.iobytestream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 基于字节的文件拷贝
 *
 *
 * 读入字节数据到数组里，在从字节数组里面写入文件中
 */
public class FileStreamCopy {
    public static void main(String[] agrs) throws IOException {
        copyWithOneByteSlow();
    }

    /**
     * ##不考虑## -----效率低
     * <p>
     * 一个个字节的读，然后写入新文件，
     * read(int)
     * write(int)
     * 缺点：文件大的时候拷贝也会很慢，效率很低。效率低下的原因：读一次然后就必须去写一次十分的耗时间
     */
    private static void copyWithOneByteSlow() throws IOException {
        FileInputStream fis = new FileInputStream("zhaohaoren.txt");
        FileOutputStream fos = new FileOutputStream("zhaohaorencopy.text");
        int content;
        while ((content = fis.read()) != -1) {
            fos.write(content);
        }
        fos.close();
        fis.close();
    }


    /**
     * ##不考虑## -----占内存
     * <p>
     * 将文件一次加载到内存中，然后去写！
     * available() 获取文件的大小
     * read(byte[])
     * write(byte[])
     * 缺点：占内存，如果文件太大，根本无法一次加载文件，会导致内存溢出
     */
    private static void copyWithFullByteFaster() throws IOException {
        FileInputStream fis = new FileInputStream("zhaohaoren.txt");
        FileOutputStream fos = new FileOutputStream("zhaohaorencopy.text");
        byte[] content = new byte[fis.available()]; //获取文件的大小，文件多大就分配多大的数组
        fis.read(content); // fis文件流读取数据加载到内存的byte数组中
        fos.write(content); // 写入文件

        fos.close();
        fis.close();
    }

    /**
     * ##可以考虑##
     *
     * 指定每次固定从流中读取定长字节，然后写入定长字节
     * read(byte[])
     * write(byte b[], int off, int len)
     */
    private static void copyWithFixedByteFaster() throws IOException {
        FileInputStream fis = new FileInputStream("zhaohaoren.txt");
        FileOutputStream fos = new FileOutputStream("zhaohaorencopy.text");

        byte[] content = new byte[1024*8]; //一般指定1024正数倍

        int len;
        while ((len = fis.read(content)) != -1) {
            //因为write方法写入byte数组的时候，当读到文件末尾的时候，不满足byte的大小，前一次读到的内容依然会保存在byte数组中！
            //read只会替换byte数组中自己读到的前面字节数，后面的还是上一次读的，
            //所以在write的时候指定写入的数据偏移量为读的时候读到的字节数，保证读写数据一致。
            fos.write(content, 0, len);
        }
        fos.close();
        fis.close();
    }
}
