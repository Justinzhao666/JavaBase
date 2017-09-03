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
 * CharStreamDemo Create on 2017/9/3
 */
package top.zhaohaoren.iocharstream;

/**
 *  字符流
 *
 *  读取一个字符的字节->转成字节->写入字符的字节
 *
 *  当做文件复制：文本复制，图片音频复制的时候不要使用字符流：很浪费，需要转换为字符再转换为字节存储，多此一举
 *  应该使用字节流，只用于传输字节！
 *
 *  使用情况：#只需要读取文件 或者只需要写入文件的时候用字符流#
 *  因为从文件中读取数据不会出现中文乱码，依据码表来读取一个个的字符
 *  而写入的时候，字符流可以写入字符串等类型，但是字节流只能写入byte
 *
 *  ## 字节流用于拷贝， 字符流用于获取或存储信息
 *
 *  # 字符流不可以拷贝非文本文件，如图片音频等
 *
 */
public class CharStreamDemo {
    public static void main(String[] args) {

    }
}
