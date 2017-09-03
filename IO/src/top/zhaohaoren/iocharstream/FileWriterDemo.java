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
 * FileWriter Create on 2017/9/3
 */
package top.zhaohaoren.iocharstream;

import java.io.FileWriter;
import java.io.IOException;

/**
 *  FileWriter:
 *  write: 不再局限于byte数组，而是可以写入字符串等多种类型数据。相对于字节流的更加方便。
 */
public class FileWriterDemo {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("zhaohaoren.txt",true);
        fw.write("赵浩任zhaohaoren");

        fw.close();

    }
}
