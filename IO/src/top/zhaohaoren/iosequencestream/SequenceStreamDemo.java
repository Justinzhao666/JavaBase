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
 * SequenceStreamDemo Create on 2017/9/3
 */
package top.zhaohaoren.iosequencestream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

/**
 * SequenceInputStream 将两个输入流 合并为一个流：两个管道接起来
 *
 * 1. 将两个输入流整合成一个：SequenceInputStream(InputStream s1, InputStream s2)
 * 2. 将多个输入流整合成一个: SequenceInputStream(Enumeration < ? extends InputStream> e)
 */
public class SequenceStreamDemo {
    public static void main(String[] args) throws IOException {

        twoSequence();
        multiSequence();
    }

    private static void twoSequence() throws IOException {
        FileInputStream fis1 = new FileInputStream("zhaohaoren.txt");
        FileInputStream fis2 = new FileInputStream("zhaohaorencopy.txt");
        SequenceInputStream sis = new SequenceInputStream(fis1,fis2);
        FileOutputStream fos = new FileOutputStream("zhaohaoren.copy");
        int content;
        while ((content = sis.read()) != -1){
            fos.write(content);
        }
        sis.close(); // sis关闭的时候同时关闭fis1和fis2
        fos.close();
    }

    private static void multiSequence() throws IOException {
        FileInputStream fis1 = new FileInputStream("zhaohaoren.txt");
        FileInputStream fis2 = new FileInputStream("zhaohaorencopy.txt");
        FileInputStream fis3 = new FileInputStream("zhaohaorencopy.text");


        Vector<FileInputStream> vector = new Vector<>();
        vector.add(fis1);
        vector.add(fis2);
        vector.add(fis3);

        Enumeration<FileInputStream> em = vector.elements();

        SequenceInputStream sis = new SequenceInputStream(em);
        FileOutputStream fos = new FileOutputStream("zhaohaoren.copy");

        int content;
        while ((content = sis.read()) != -1){
            fos.write(content);
        }
        sis.close(); // sis关闭的时候同时关闭fis1和fis2
        fos.close();

    }
}
