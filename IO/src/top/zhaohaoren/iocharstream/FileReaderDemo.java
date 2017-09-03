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
 * FileReaderDemo Create on 2017/9/3
 */
package top.zhaohaoren.iocharstream;

import java.io.FileReader;
import java.io.IOException;

/**
 *  FileReader
 *
 *  read(): 读取一个字符，返回值是一个字符的int值，需要转换为char才能得到字符
 *          FileInputStream读取的是一个字节，而不是一个字符。FileReader本身也是是读取的字节
 *          但是它会针对查询编码表确定需要读入大小确定多少字节是一个字符。
 */
public class FileReaderDemo {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("zhaohaoren.txt");
        int content;
        while ((content = fr.read())!=-1){
            System.out.println((char) content);
        }
        fr.close();
    }
}
