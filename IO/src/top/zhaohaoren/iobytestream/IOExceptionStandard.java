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
 * IOExceptionStandard Create on 2017/9/3
 */
package top.zhaohaoren.iobytestream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * IO流和异常的标准写法：
 * 1.6的标准写法
 * 1.7的标准写法
 */
public class IOExceptionStandard {
    public static void main(String[] args) {


    }

    /**
     * 1.7版本及之后的IO流标准写法:
     *
     * 打开流放入try()括号中，大括号里面写操作，不需要调用close方法，流会自动关闭！
     * 【不是所有东西都可以放入这个括号中的，必须是实现了AutoCloseable接口（1.7新加接口）的类对象才能放入该括号中，
     *  意指是可以自己关闭的类，可以调用close方法的类对象】
     *
     *  这里面异常应该抛给上级，不能再本地处理，不然会在此中断异常信息。
     *
     **/
    private static void IOException1_7() throws IOException {
        try (
                FileInputStream fis = new FileInputStream("zhaohaoren.txt");
                FileOutputStream fos = new FileOutputStream("zhaohaoren.copy.txt");
        ) {
            int len;
            byte[] bytes = new byte[1024];
            while ((len = fis.read(bytes)) != -1) {
                fos.write(bytes);
            }
        }
    }

    /**
     * 1.6版本及之前的IO流标准写法:
     **/
    private static void IOException1_6() throws IOException {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("zhaohaoren.txt");
            fos = new FileOutputStream("zhaohaoren.copy.txt");
            int len;
            byte[] bytes = new byte[1024];
            while ((len = fis.read(bytes)) != -1) {
                fos.write(bytes);
            }
        } finally {
            //为了让流尽可能的关闭：在打开流和关闭流的时候都有可能出错导致流关闭出问题，所以都要try一下，能关一个是一个
            try {
                if (fis != null) { //如果打开流失败fis会是null(文件不存在)，这样就不用关闭了，否则会控制针异常。
                    fis.close();
                }

            } finally {
                if (fos != null) {
                    fos.close();
                }
            }
        }


    }
}

class MyCloser implements AutoCloseable{

    @Override
    public void close() throws Exception {

    }
}


