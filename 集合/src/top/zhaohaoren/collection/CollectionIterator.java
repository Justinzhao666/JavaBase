/*
 * Copyright (c) 2017/8/26 by zhaohaoren
 * Welcome to visit my site:
 *  
 *  www.zhaohaoren.top
 *
 * @ Project: JavaBase
 * @ Lan: Java
 * @ author zhaohaoren
 * @ version 1.0 
 * CollectionIterator Create on 2017/8/26
 */
package top.zhaohaoren.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 *  Iterator对象对集合进行迭代,用来遍历所有的集合类！
 *  主要函数：
 *  hasNext()
 *  next()
 *  remove()
 *
 *  使用
 *  1. 获取迭代器
 *  2. 调用迭代器方法hasNext判断后，next取出
 *
 *  原理：所有集合的子类都有重写Iterator的方法
 */
public class CollectionIterator {
    public void main(String[] agrs){
        System.out.println("");
        Collection  c = new ArrayList();
        c.add("a");
        c.add("b");
        c.add("c");
        c.add("d");

        //1: 获取迭代器
        Iterator iterator = c.iterator();
        //2: 判断迭代器中是否还能取出数据
        while (iterator.hasNext()){
            //:3 输出数据
            System.out.println(iterator.next());
        }
    }
}
