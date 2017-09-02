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
 * FileBufferCopy Create on 2017/9/2
 */
package top.zhaohaoren.iostream;

import java.io.*;

/** ##推荐##  ---- 和使用定长数组方式复制效率差不多，都可以。
 *
 *  BufferedInputStream：对InputStream做了包装
 *
 *  原理：
 *  Buffered的里面定义了一个byte[8192]大小的数组
 *  相当于我一次性从文件管道流中读取8192个字节的数据，然后再一个字节一个字节的写入到BufferedOutputStream的8192个字节数组中去，
 *  然后再一次性写入byte[8192]的数据到文件中，因为一字节一字节的转移是在内存中，所以很快！但是读取是磁盘到内存的IO很慢！
 *
 */
public class FileBufferCopy {
    public static void main(String[] agrs) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("zhaohaoren.txt")) ;
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("zhaohaorencopy.text"));
        int content;
        // bis.read() bos.write()都是内存中的操作，将buffered的内容一个字节一个字节的复制到OutputStream的buffer字符数组中
        while ((content = bis.read()) != -1) {
            bos.write(content);
        }
        bis.close();
        bos.close();
    }
}
