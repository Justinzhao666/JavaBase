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
 * ListConcurrentModified Create on 2017/8/27
 */
package top.zhaohaoren.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * List迭代中的并发修改异常
 *
 * List自带ListIterator对象
 * hasNext(),next()
 * hasPrevious(),previous()
 *
 * 当使用迭代器对list进行迭代的时候，不可以添加或者删除list中的元素（可以修改，主要索引不能变动），否则会发生ConcurrentModificationException异常
 * 如果一定要修改：
 * 1.要么使用list.get方法进行遍历
 * 2.要么就使用list-iterator自带的修改方法。
 */
public class ListConcurrentModified {
    public static void  main(String[] args){


        List  list = new ArrayList();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");

        // 如果使用迭代器遍历，list的add和remove方法是不能在迭代器遍历中使用的。 一边迭代一边修改会影响迭代。
/*
        Iterator  iterator = list.iterator();
        while (iterator.hasNext()){
            String s = (String)iterator.next();
            if (s.equals("a")){
                list.add(1,"aaa"); //迭代中就不能这样修改list了
            }
            System.out.println(s);
        }
*/
        // 如果想要迭代中修改使用list自己定义的迭代器
        ListIterator iterator2 = list.listIterator();
        while (iterator2.hasNext()){
            String str = (String)iterator2.next();
            if (str.equals("a")){
//                list.add(1,"aaa");
                iterator2.add("aaa"); //即便是增加，也只能添加到最后，不能中间插入！
            }
            System.out.println(str);
        }
        System.out.println(list);


    }
}
