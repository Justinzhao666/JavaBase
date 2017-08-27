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
 * GenericIterator Create on 2017/8/27
 */
package top.zhaohaoren.generic;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 制定泛型后对容器的遍历
 */
public class GenericIterator {
    public static void main(String[] agrs) {

        ArrayList<String> arr = new ArrayList<>();
        arr.add(new String("1"));
        arr.add(new String("2"));
        arr.add(new String("3"));
        arr.add(new String("4"));
        arr.add(new String("5"));

        Iterator<String> iterator = arr.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next()); //使用了泛型后 迭代器返回的值也是泛型的类型，所以不需要强制转换
        }
    }
}
