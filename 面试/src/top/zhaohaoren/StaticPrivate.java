/*
 * Copyright (c) 2017/9/28 by zhaohaoren
 * Welcome to visit my site:
 *  
 *  www.zhaohaoren.top
 *
 * @ Project: JavaCode
 * @ Lan: Java
 * @ author zhaohaoren
 * @ version 1.0 
 * StaticPrivate Create on 2017/9/28
 */
package top.zhaohaoren;

/**
 *
 * 私有静态成员属性，也只能在类内访问：
 * static虽然是静态的，放在静态存储区
 * 但是被private修饰作用域依然只能在类内部
 */
public class StaticPrivate {

    private static int num = 1;

    public static void main(String[] args) {
        StaticPrivate sp = new StaticPrivate();
        //类内部随便访问
        System.out.println(sp.num++);
        System.out.println(StaticPrivate.num);
    }
}

class Out {
    public Out() {
        StaticPrivate sp = new StaticPrivate();
        //类外不可以访问private的值，即便是static的
        //sp.num;
        //StaticPrivate.num;
    }
}