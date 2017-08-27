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
 * ListDemo Create on 2017/8/27
 */
package top.zhaohaoren.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *  list的特有方法
 *  add：尾部添加元素，内部插入元素
 *  remove：删除制定元素(不会自动装箱)
 *  get：获取指定元素
 *  set：设置指定元素
 *
 *  list有三个儿子：
 *  数组：ArrayList ， Vector
 *  链表：LinkedList
 */
public class ListDemo {
    public static void main(String[] args){

        List  list = new ArrayList(); //现在都不指定泛型的情况下使用
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add(4,"e");
        list.add(4,"f");  // add其实不是添加，而是insert，他会在将数据插入你指定的位置，原来的数据统一往右移
        //list.add(10,"e");
        //索引越界异常，因为在add后所产生的新数组就是那么大，你插入10这个位置是不存在该索引的！
        System.out.print(list);

        list.remove(1);//删除制定索引的值
        //list.remove('f');//删除指定的对象,这里并不会自动装箱！-因为如果装箱会和索引参数二义
        list.set(1,"aaa");// 设置制定索引的值
        System.out.println(list);

        // 使用list的get()进行遍历
        for(int i = 0;i<list.size();i++){
            System.out.println(list.get(i));
        }
        // 也可以用集合的迭代器遍历: 适用于任何集合
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
