/*
 * Copyright (c) 2017/8/23 by zhaohaoren
 * Welcome to visit my site:
 *  
 *  www.zhaohaoren.top
 *
 * @ Project: JavaBase
 * @ Lan: Java
 * @ author zhaohaoren
 * @ version 1.0 
 * ArrayDemo Create on 2017/8/23
 */
package top.zhaohaoren.collection;

import java.util.*;

/**
 * 数组转集合
 * 集合转数组
 */
public class ArrayDemo {
    public static void main(String[] agrs) {


        /** 数组转集合 asList */

        //： 基本数据类型
        //:     基本数据类型转集合会将整个数组当初一个对象传入asList，如果非想转就使用包装类。
        int[] a = {1, 2, 3, 4};
        List as = Arrays.asList(a);
        System.out.println(as);


        //： 对象类型
        //:     数组转集合后不能添加元素,用处就是为了可以用集合的方式来操作数组了
        String[] arr = {"a", "b", "c"};
        List<String> arrs = Arrays.asList(arr);
        // arrs.add("d");
        System.out.println(arrs);

        /** 集合转数组-带泛型 toArray */
        Collection<String> c = new ArrayList<>();
        c.add("a");
        c.add("b");
        c.add("c");
        c.add("d");
        String[] cs = c.toArray(new String[0]);
        // toArray当传入泛型的时候，需要传入一个数组来存储集合中的元素，如果传入数组足够大，多余的数据为null，如果不够，则会返回一个新的数组。

        for (String s : cs) { //数组不能直接print的，需要遍历输出，因为它没有重写toString方法
            System.out.print("#" + s);
        }

    }
}
