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
 * PrintStreamDemo Create on 2017/9/3
 */
package top.zhaohaoren.ioothers;

import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 *  打印流：方便的调用对象的toString方法并输出，System.out就是一个打印流,打印到终端
 *  PrintStream
 *  PrintWriter
 *
 *  PrintWriter具有自动刷出功能[缓存中的数据强制刷入到文件中]，只针对println。（没啥实际用处，只要调用close方法这些都是浮云，而且close一定会调用）
 */
public class PrintStreamDemo {
    public static void main(String[] args) throws FileNotFoundException {
        PrintStream ps = System.out; //获取标准输出流，默认指向的是控制台
//      PrintStream ps = new PrintStream("zhaoahaoren.txt");

        ps.println(97); //将97转为字符串
        ps.write(97); // 将97进行查表 存入字符。
        ps.print(99);

        ps.close();
    }
}
