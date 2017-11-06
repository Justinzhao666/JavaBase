/*
 * Copyright (c) 2017/9/28 by zhaohaoren
 * Welcome to visit my site:
 *  
 *  www.zhaohaoren.top
 *
 * @ Project: JavaCode
 * @ Lan: Java
 * @ author zhaohaoren
 * @ version 1.0 
 * NullClassConvert Create on 2017/9/28
 */
package top.zhaohaoren;

/**
 *  null 表示不确定类型，即可以是任意类型
 *  对null使用强制转换 = 被转换的类，只有类信息，不是一个对象，只可以访问静态成员，不能访问非静态成员。
 */
public class NullClassConvert {

    private static int num = 1;
    private int num2 = 2;
    public static void main(String[] args) {
        System.out.println( ((NullClassConvert)null).num);
        System.out.println( ((NullClassConvert)null).num2);  //错误：空指针异常
    }
}


