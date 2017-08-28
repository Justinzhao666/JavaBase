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
 * TreeMapDemo Create on 2017/8/29
 */
package top.zhaohaoren.map;

import java.util.TreeMap;

/**
 * TreeMap
 * 按照Map的键进行排序的
 * <p>
 * Tree是用来排序的，不同于hashmap这些，Tree存入数据时是调用compareTo方法来和要被插入的数进行比较的。
 * <p>
 * 加入Tree中的类都要实现Comparable接口
 */
public class TreeMapDemo {
    public static void main(String[] agrs) {
        TreeMap<MyObject, String> tm = new TreeMap<>();
        tm.put(new MyObject(1), "aa");
        tm.put(new MyObject(2), "aqa");
        tm.put(new MyObject(3), "aac");
        tm.put(new MyObject(4), "aas");
        System.out.print(tm);

    }
}


class MyObject implements Comparable<MyObject> {
    Integer id;

    public MyObject(Integer id) {
        this.id = id;
    }

    @Override
    public int compareTo(MyObject o) {
        return this.id - o.id;
    }

    @Override
    public String toString() {
        return "MyObject{" +
                "id=" + id +
                '}';
    }
}