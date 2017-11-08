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
 * PictureEncry Create on 2017/9/3
 */
package top.zhaohaoren.demo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 图片文字加密
 *
 * 使用抑或 ^  加密解密对称，两次抑或还原。
 * 因为一个字节抑或两字等于原字节！
 */
public class PictureEncry {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("zhaohaoren.txt");
        FileOutputStream fos = new FileOutputStream("zhaohaorencopy.text");
        int content;
        while ((content = fis.read()) != -1) {
            fos.write(content ^ 123); //将字节和123做 抑或，解密的话就再执行一次抑或来还原
        }
        fos.close();
        fis.close();
    }
}
