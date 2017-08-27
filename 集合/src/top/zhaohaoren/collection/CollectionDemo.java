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
 * CollectionDemo Create on 2017/8/23
 */
package top.zhaohaoren.collection;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Collection接口
 * 集合框架的根接口的基本方法。
 * boolean add(E e)
 * boolean remove(Object o)
 * void clear()
 * boolean contains(Object o)
 * boolean isEmpty()
 * int size()
 * 遍历集合对象
 * boolean addAll(Collection c)
 * boolean removeAll(Collection c)
 * boolean containsAll(Collection c)
 * boolean retainAll(Collection c)
 */
public class CollectionDemo {

    public static void main(String[] args) {
        Collection c = new ArrayList(); //不加泛型

        //: add
        // # collection可以添加任意对象
        boolean b = c.add("abc"); // 有返回值,ArrayList返回的是一直为true
        c.add(100);
        c.add(100);
        c.add(true);
        c.add(new Object());
        System.out.println(b);
        System.out.println(c); //ArrayList的toString在其父类AbstractCollection被重写

        // 对集合进行遍历，需要转为Array，主要是因为collection对象没有获取值得方法 c.xxx()
        Object[] arr = c.toArray();
        for (int i = 0; i < c.size(); i++) {
            System.out.print(arr[i]);
        }
        System.out.println();

        //: remove
        // # 删除元素
        c.remove(100); // 删除list中的第一个
        System.out.println(c);

        //: clear
        // # 清空集合
        c.clear();
        System.out.println(c);

        //: isEmpty
        // # 判断是否为空
        System.out.println(c.isEmpty());

        //: contains
        // 是否包含某元素
        System.out.println(c.contains(100));

        //: size()
        // 集合的大小
        System.out.println(c.size());

        Collection c1 = new ArrayList();
        c1.add('a');
        c1.add('b');
        c1.add('c');
        c1.add('d');
        Collection c2 = new ArrayList();
        c2.add('a');
        c2.add('b');
        c2.add('c');

        //: addAll()
        // 融合c2到c1中
        c1.addAll(c2);
        // c1.add(c2) //将c2作为一个元素计入c1中
        System.out.println(c1);

        //: removeAll()
        // 删除两个集合的交集
        c1.removeAll(c2);
        System.out.println(c1);


        //: containsAll()
        // c1是否包含c2： c2为c1的子集才会返回true
        c2.add('z');
        System.out.println(c1.containsAll(c2));
        System.out.println(c1);

        //: retainAll()
        // 求出c1和c2的交集并赋值给c1！
        // ！！如果c1发生了变化返回true，否则返回false。 也就是说只有c1和c2的交集还是c1的时候，返回false！
        System.out.println(c1.retainAll(c2));
        System.out.println(c1);

    }
}
