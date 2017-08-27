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
 * ThreeIteratorDemo Create on 2017/8/27
 */
package top.zhaohaoren.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * 集合的三种迭代方式
 * 1. for
 * 2. iteration
 * 3. foreach ----只能用来遍历，不能用来删除
 *
 * 以及迭代过程中对容器删除元素
 */
public class ThreeIteratorDemo {
    public static void main(String[] agrs) {

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("a");
        arrayList.add("a");
        arrayList.add("c");
        arrayList.add("d");
        arrayList.add("e");

        /** 1: for循环 */
        for (int i = 0; i < arrayList.size(); i++) {
            if ("a".equals(arrayList.get(i))) {
                //arrayList.remove(i);
                arrayList.remove(i--);
            }
        }
        // 结果： 不会被删除，remove方法调用后，数组重新分配，数据全部上移，但是索引并没有变，所以中间会漏掉一个元素。
        // 解决方法： arrayList.remove(i--); 如果删除让索引的游标也跟着上移一个。
        System.out.println(arrayList);

        /** 2: 迭代器 */
        ListIterator listIterator = arrayList.listIterator();
        while (listIterator.hasNext()) {
            if ("a".equals(listIterator.next())) {
                listIterator.remove();
            }
        }
        //2.2: 迭代器的另一种写法
//        for (ListIterator listIterator1 = arrayList.listIterator();listIterator.hasNext()){
//
//        }
        System.out.println(arrayList);


        /** 3. foreach */
/*

        for (String str: arrayList
             ) {
            if ("a".equals(str)) {
                arrayList.remove(new String("a"));
            }
        }
        //结果：不能删除，因为foreach底层使用的就是迭代器，所以如果直接对list进行删除会报ConcurrentModificationException错误。
        System.out.println(arrayList);
*/

    }
}
