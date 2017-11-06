/*
 * Copyright (c) 2017/11/1 by zhaohaoren
 * Welcome to visit my site:
 *  
 *  www.zhaohaoren.top
 *
 * @ Project: JavaCode
 * @ Lan: Java
 * @ author zhaohaoren
 * @ version 1.0 
 * StringBuffer Create on 2017/11/1
 */
package top.zhaohaoren.String相关;

import java.util.Collection;
import java.util.Collections;

/**
 *  String是不可变类
 *  StringBuffer是可变类，线程安全的。
 *  StringBuilder也是基于缓冲区的，但是是线程不安全的，单线程的时候效率要高点。
 *
 *  当字符串需要经常被修改的时候，最好使用StringBuffer来实现。
 */
public class StringBuffer问题 {
    public static void main(String[] args) {

        // String直接修改字符串
        String str = "abc";
        str += "d";
        // 上述修改等价于如下： 创建了很多临时的对象，很浪费！
         StringBuffer sb = new StringBuffer(str);
        sb.append("d");
        str = sb.toString();

        // 创建StringBuffer对象只能通过构造形式创建。
        StringBuffer sb2 = new StringBuffer("aaaa");


    }
}
