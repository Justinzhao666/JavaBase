/*
 * Copyright (c) 2017/8/27 by zhaohaoren
 * Welcome to visit my site:
 *  
 *  www.zhaohaoren.top
 *
 * @ Project: JavaBase
 * @ Lan: Java
 * @ author zhaohaoren
 * @ version 1.0 
 * LinkedHashSetDemo Create on 2017/8/27
 */
package top.zhaohaoren.set;

import java.util.LinkedHashSet;

/**
 * LinkedHashSet
 * 底层是使用链表来实现的;
 * 不可以存入重复数据，继承自Set，拥有Set的特性;
 *
 * > 在Set中唯一一个有序的Set：怎么存就能怎么取出来!!!
 */
public class LinkedHashSetDemo {
    public static void main(String[] agrs){
        LinkedHashSet<String> lhs = new LinkedHashSet<>();
        lhs.add("a");
        lhs.add("a");
        lhs.add("a");
        lhs.add("b");
        lhs.add("c");
        lhs.add("c");
        lhs.add("d");

        System.out.println(lhs);
    }
}
