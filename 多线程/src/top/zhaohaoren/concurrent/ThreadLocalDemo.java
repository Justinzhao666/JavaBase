/*
 * Copyright (c) 2017/11/7 by zhaohaoren
 * Welcome to visit my site:
 *  
 *  www.zhaohaoren.top
 *
 * @ Project: JavaCode
 * @ Lan: Java
 * @ author zhaohaoren
 * @ version 1.0 
 * ThreadLocalDemo Create on 2017/11/7
 */
package top.zhaohaoren.concurrent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 *
 *  这篇有问题，看博客，以后再丰富！
 *
 *  ThreadLocal
 *
 *  set()
 *  get()
 *
 *  等同于将全局变量转为线程的局部变量。达到将不安全转为安全的目的。
 *
 *  threadlocal中有一个map用于存储每一个线程变量的副本
 *
 *  因为每一个线程都有一个ThreadLocalMap对象，定义在Thread类中的！然后这个Map里面存入key为线程 value为副本值。
 *  ThreadLocal 会getMap取得这个线程的Map对象。
 *
 *
 *  ThreadLocal的作用就是管理每个线程内部的那个Map；
 *
 *  看set方法，
 *  首先检验的是你线程中是创建了Map，
 */
public class ThreadLocalDemo {

    // 创建ThreadLocal对象
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    // 数据库的一个连接，一般在Dao中都是单例的，当我们多个线程访问的时候希望每个线程都有自己的连接
    private static Connection conn = null;

    static {
        try {
            conn = DriverManager.getConnection("url, name and password");
        } catch (SQLException e) {
//            DriverManager.getConnection()
            e.printStackTrace();
        }
    }

    public Connection getConnection(){
        Connection connection = threadLocal.get();
        if (null == connection){
            threadLocal.set(connection);
        }
        return connection;
    }

    public static void main(String[] args) {

    }
}
