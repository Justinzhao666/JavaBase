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
 * SystemInOutDemo Create on 2017/9/4
 */
package top.zhaohaoren.ioothers;

import java.io.*;

/**
 *  改变标准输入输出流：
 *
 *  System.in 和 System.out 也是流，System类的定义：
 *  public final static PrintStream out = null;
 *  public final static InputStream in = null;
 *  标准输入输出流指的是System.in 和System.out 一个指向的是键盘，一个指向的是控制台
 *
 *  System.setIn(); 将原始的标准输入流重定向
 *  System.setOut(); 将标准的输出流重定向
 *  修改了输入输出流后的System流 就是修改所指向的内容。
 *
 */
public class SystemInOutDemo {
    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("zhaohaoren.txt"));  //改变标准输入流  键盘 改为 文件
        System.setOut(new PrintStream("zhaohaorencopy.txt")); // 改变标准输出流 控制台 改为 文件

        InputStream is = System.in;
        PrintStream ps = System.out;

        int b;
        while((b=is.read())!=-1){
            ps.write(b);
        }

        is.close();
        ps.close();

//        System.out.println(); 这种输出流不需要关闭，因为他不是一个内存和文件的管道，不会涉及磁盘IO
    }
}
