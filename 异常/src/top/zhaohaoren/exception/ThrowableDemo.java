/*
 * Copyright (c) 2017/8/31 by zhaohaoren
 * Welcome to visit my site:
 *  
 *  www.zhaohaoren.top
 *
 * @ Project: JavaCode
 * @ Lan: Java
 * @ author zhaohaoren
 * @ version 1.0 
 * ThrowableDemo Create on 2017/8/31
 */
package top.zhaohaoren.exception;

/**
 *  Throwable 重要函数
 *
 */
public class ThrowableDemo {
    public static void main(String[] args) {

        try {
            System.out.print(1/0);
        }catch (Throwable e){
            e.printStackTrace(); //打印异常信息，JVM默认就是调用这个的
            System.out.println(e.getMessage()); //获取异常的信息
            System.out.println(e.toString()); //获取类名和异常信息，返回字符串
        }

        System.out.println("你好"); //只要catch处理了那就是会执行的
    }
}
