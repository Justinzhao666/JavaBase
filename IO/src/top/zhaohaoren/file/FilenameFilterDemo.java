package top.zhaohaoren.file;/*
 * Copyright (c) 2017/9/2 by zhaohaoren
 * Welcome to visit my site:
 *  
 *  www.zhaohaoren.top
 *
 * @ Project: JavaBase
 * @ Lan: Java
 * @ author zhaohaoren
 * @ version 1.0 
 * top.zhaohaoren.file.FilenameFilterDemo Create on 2017/9/2
 */

import java.io.File;
import java.io.FilenameFilter;

/**
 *  文件名过滤器
 *
 *  list传入一个过滤器对象，满足accept条件的对象
 */
public class FilenameFilterDemo {
    public static void main(String[] agrs) {


        File dir = new File("F:\\Java\\JavaBase\\IO\\src");

        String[] arrs  = dir.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                                    // dir 就是上面的dir name是dir.list()下的文件名：看源码
                File f = new File(dir,name);
                return f.isFile() && name.endsWith(".txt");
            }
        });

        for (String s : arrs) {
            System.out.println(s);
        }
    }
}
