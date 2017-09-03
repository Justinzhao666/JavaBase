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
 * LineNumberReaderDemo Create on 2017/9/3
 */
package top.zhaohaoren.iocharstream;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

/**
 * LineNumberReader （extends BufferedReader）
 *
 * 可带行号的读取
 *
 * readLine: 一行文本内容
 * setLineNumber: 设置起始的行号
 * getLineNumber：获取当前的行号，设置的行号上readLine一次就++一次
 */
public class LineNumberReaderDemo {
    public static void main(String[] args) throws IOException {
        LineNumberReader lnr = new LineNumberReader(new FileReader("zhaohaoren.txt"));
        String line;
        lnr.setLineNumber(100);
        while ((line = lnr.readLine()) != null) {
            System.out.println(lnr.getLineNumber() + ":" + line);
        }
        lnr.close();
    }
}
