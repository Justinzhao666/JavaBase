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
 * PropertiesDemo Create on 2017/9/4
 */
package top.zhaohaoren.ioothers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *  Properties extends HashTable
 *  不是一个流，是一个map，项目中用于使用流去读取配置文件,不需要指定泛型
 *
 *  之所以和IO相关，因为他也算是一个IO流的包装类，传入IO流对象即可。
 */
public class PropertiesDemo {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.put("abc","123");
        System.out.println(properties);

        properties.setProperty("name","zhaohaoren"); //设置键和值
        properties.getProperty("name"); //获取制定键的值
        properties.propertyNames(); //获取所有的键

        /** IO相关 **/
        // 将配置文件的键值对读取到集合中去
        properties.load(new FileInputStream("config.properties"));
        System.out.println(properties);
        properties.setProperty("name","justin");

        properties.store(new FileOutputStream("config.properties"),null);
        // 不给null会在文件内加入一行你填写参数的注释，key-value好像需要是字符串才能写入文件
        System.out.println(properties);
    }
}
