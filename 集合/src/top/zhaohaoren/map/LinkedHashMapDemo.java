/*
 * Copyright (c) 2017/8/29 by zhaohaoren
 * Welcome to visit my site:
 *  
 *  www.zhaohaoren.top
 *
 * @ Project: JavaBase
 * @ Lan: Java
 * @ author zhaohaoren
 * @ version 1.0 
 * LinkedHashMap Create on 2017/8/29
 */
package top.zhaohaoren.map;

import java.util.LinkedHashMap;

/**
 * LinkedHashMap 属于HashMap派系
 * 底层是链表实现的，可以保证怎么存就怎么取。--是有顺序的
 */
public class LinkedHashMapDemo {
    public static void main(String[] agrs) {

        LinkedHashMap<String,Integer> lhm = new LinkedHashMap<>();
        lhm.put("a",1);
        lhm.put("a",1);
        lhm.put("b",1);
        lhm.put("c",1);
        lhm.put("d",1);
        System.out.print(lhm);

    }
}
