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
package top.zhaohaoren.iostream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *  FileOutputStream
 *
 *  指定输出对象，写入数据！
 *
 *  IO流的核心，读数据写数据
 *
 */
public class FileOutputStreamDemo {
    public static void main(String[] agrs) throws IOException {

        // 创建输出流的对象，如果没有会自动创建文件。
        FileOutputStream fos = new FileOutputStream("fos.txt",true); //不加true写入文件会覆盖原文本！
        fos.write(97); //写入会将int的前3个字节0去掉
        fos.write(99);
        fos.write(98);
        fos.close();


        copyRes();
    }


    /** IO流最核心的代码 */
    public static void copyRes() throws IOException {

        /*  一个个字节的读，然后写入新文件，文件大的时候拷贝也会很慢，效率很低。
         *  效率低下的原因：读一次然后就必须去写一次十分的耗时间
         *  */
        FileInputStream  fis = new FileInputStream("zhaohaoren.txt");
        FileOutputStream fos = new FileOutputStream("zhaohaorencopy.text");
        int content;
        while ((content = fis.read())!=-1){
            fos.write(content);
        }
        fos.close();
        fis.close();

    }

}
