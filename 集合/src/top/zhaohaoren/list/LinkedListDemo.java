/*
 * Copyright (c) 2017/8/27 by zhaohaoren
 * Welcome to visit my site:
 *  
 *  www.zhaohaoren.top
 *
 * @ Project: JavaCode
 * @ Lan: Java
 * @ author zhaohaoren
 * @ version 1.0 
 * LinkedListDemo Create on 2017/8/27
 */
package top.zhaohaoren.list;

import java.util.LinkedList;

/**
 * LinkedList常用方法
 * 特有的
 * addFirst
 * addLast
 * removeFirst
 * removeLast
 */
public class LinkedListDemo {
    public static void main(String[] agrs) {
        LinkedList  linkedList = new LinkedList();
        linkedList.addFirst("aa");
        linkedList.addFirst("bb");
        linkedList.addFirst("cc");
        linkedList.addFirst("dd");
        linkedList.addLast("ee");

        System.out.println(linkedList);
        linkedList.removeFirst();
        linkedList.removeLast();
        System.out.println(linkedList);

    }
}
