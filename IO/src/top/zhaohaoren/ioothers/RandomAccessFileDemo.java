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
 * RandomAccessFileDemo Create on 2017/9/4
 */
package top.zhaohaoren.ioothers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 随机访问流
 * RandomAccessFile，不属于流的体系，父类是Object
 * 雌雄同体：既可以读又可以写
 *
 * seek(long) : 可以指定文件管道的位置！让管道在文件的具体位置开始写入
 * 用途： 多线程下载，各自下载各自的部分
 */
public class RandomAccessFileDemo {
    public static void main(String[] args) throws IOException {

        RandomAccessFile raf = new RandomAccessFile(new File("zhaohaoren.txt"),"rw");
        raf.seek(0);
        raf.write(97);
        raf.close();
    }
}
