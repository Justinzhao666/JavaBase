/*
 * Copyright (c) 2017/8/28 by zhaohaoren
 * Welcome to visit my site:
 *  
 *  www.zhaohaoren.top
 *
 * @ Project: JavaBase
 * @ Lan: Java
 * @ author zhaohaoren
 * @ version 1.0 
 * SetToRemoveRepeat Create on 2017/8/28
 */
package top.zhaohaoren.set;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

/**
 *  Set 经常用于去重
 *  当有题目问你将输入源重复数据去重的话，优先考虑使用set
 *
 *
 *  例子：
 *      去除List中的重复元素
 *  思路：
 *      将list的数据存入set，然后将set重新赋值给list
 */
public class SetToRemoveRepeat {
    public static void main(String[] agrs) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(3);
        arrayList.add(1);
        arrayList.add(4);
        arrayList.add(12);
        arrayList.add(1);
        arrayList.add(11);

        getSingle(arrayList);
        System.out.print(arrayList);
    }

    /**
     * 去重函数
     * */
    private static void getSingle(List<Integer> arrayList) {
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.addAll(arrayList); //addAll()方法可以添加所有的Collection集合的子类
        arrayList.clear();
        arrayList.addAll(linkedHashSet);
    }


}
