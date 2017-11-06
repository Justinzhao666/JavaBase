/*
 * Copyright (c) 2017/11/1 by zhaohaoren
 * Welcome to visit my site:
 *  
 *  www.zhaohaoren.top
 *
 * @ Project: JavaCode
 * @ Lan: Java
 * @ author zhaohaoren
 * @ version 1.0 
 * 基本数据类型包装类值比较 Create on 2017/11/1
 */
package top.zhaohaoren.基本数据类型包装类;

/**
 *  <， >, 比较只能用于基本数据类型，包装类型是通过包装类的intValue方法获取基本数据类型后进行比较的
 *  == 比较的是地址，包装类地址肯定不同
 *
 *  如何比较：
 *  包装类提供了compareTo()方法
 */
public class 基本数据类型包装类值比较 {
    public static void main(String[] args) {
        Integer i1 = new Integer(100);
        Integer i2 = new Integer(100);

        System.out.println(i1>i2);
        System.out.println(i1==i2); //返回flase，因为比较的是地址
        System.out.println(i1<i2);

        System.out.println(i1.compareTo(i2));

    }
}
