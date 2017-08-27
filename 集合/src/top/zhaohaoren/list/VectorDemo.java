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
 * VectorDemo Create on 2017/8/27
 */
package top.zhaohaoren.list;

import java.util.Enumeration;
import java.util.Vector;

/**
 *  Vector数组
 *  Vector是jdk版本很早就出现了，历史比collection都要久，所以有些规范是和异常有区别的。
 *  现在基本不用了，即使他是线程安全的。他已经被ArrayList给替代了。
 *  尽管它已经实现了List接口（可以使用list的方法），但还是不咋用。
 *
 *  线程安全，效率比ArrayList要差
 *
 */
public class VectorDemo {
    public static void main(String[] agrs) {

        // 我们可以使用list的add等方法，但这里使用了Vector最原始的方法
        Vector v = new Vector();
        v.addElement("a");
        v.addElement("b");
        v.addElement("c");
        v.addElement("d");

        //遍历
        Enumeration e = v.elements(); //获取迭代器
        while (e.hasMoreElements()){
            System.out.println(e.nextElement());
        }
    }
}
