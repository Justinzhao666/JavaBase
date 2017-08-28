/*
 * Copyright (c) 2017/8/28 by zhaohaoren
 * Welcome to visit my site:
 *  
 *  www.zhaohaoren.top
 *
 * @ Project: JavaCode
 * @ Lan: Java
 * @ author zhaohaoren
 * @ version 1.0 
 * TreeSetDemo Create on 2017/8/28
 */
package top.zhaohaoren.set;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * TreeSet： 底层是一个二叉树： 小的存储在左边，大的存储在右边：排序规则需要自己来指定！
 * 特性：（主要取决于你定义的排序，你可以让其可以存入相同的数据-返回值永不为0）
 * 1.数据不重复
 * 2.数据有排序
 * <p>
 * 原理：
 * TreeSet是一个二叉树！
 * 第一个数据存入作为根节点，然后插入下一个元素。
 *      如果下一个元素和第一个元素compareTo比较后 返回为正，将元素放入根的右边；
 *      如过比较结果为负，将元素放入根的左边；
 *      如果比较结果为0，表示这两个数据一样，丢弃不存入。
 * 再插入下一个元素，该元素会从根节点开始不断和它将要放到的位置上的元素进行比较，直到找到没有被占据的位置存入。
 * 取值： 从根节点开始往最左边找，将左边的取出来再取出中间的最后取出右边的-先序遍历
 * <p>
 * 应用：
 * 1. 去重
 * 2. 排序！----compareTo返回值设置为0就返回一个数，返回值为负数按照反序排列，返回值为正数按照正序排列（怎么存就怎么取）。
 * <p>
 * 重点：(两种排序)
 * 1、自定义类实现 Comparable 以满足排序的需求；
 * 2、jdk自带类向set传入 Comparator 对象比较器来定义排序方式；
 *
 */
public class TreeSetDemo {
    public static void main(String[] agrs) {

        //: 使用基本数据类型包装类
        treeSetInteger();

        //: 使用自定义对象 ----自定义对象需要实现comparable接口
        treeSetMyObject();

        //: 修改String的比较方法，使用自己定义的比较方法（让String按照字符串长度排序）
        treeSetStringOfMyCompare();
    }

    private static void treeSetStringOfMyCompare() {
        // 需要传入Comparator接口自己实现类的对象，来自定义比较
        TreeSet<String> treeSet = new TreeSet(new MyStringCompare()); //可以使用匿名内部类来实现

        treeSet.add("a");
        treeSet.add("babb");
        treeSet.add("ac");
        treeSet.add("ss");
        treeSet.add("ahmadabad");
        System.out.println(treeSet);
    }

    private static void treeSetMyObject() {
        TreeSet<Person> ts = new TreeSet<>();
        ts.add(new Person("zhao", 23));
        ts.add(new Person("acher", 13));
        ts.add(new Person("billy", 24));
        ts.add(new Person("zhao", 23));
        ts.add(new Person("justin", 22));
        System.out.println(ts);
    }

    private static void treeSetInteger() {
        TreeSet<Integer> treeSet = new TreeSet();
        treeSet.add(1);
        treeSet.add(1);
        treeSet.add(3);
        treeSet.add(3);
        treeSet.add(2);
        treeSet.add(1);
        System.out.println(treeSet);
    }
}

class MyStringCompare implements Comparator<String> {/*extends Object*/

    @Override
    public int compare(String o1, String o2) {
        int num = o1.length() - o2.length();
        return num == 0 ? o1.compareTo(o2) : num;
    }
}