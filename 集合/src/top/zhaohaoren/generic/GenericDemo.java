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
 * GenericDemo Create on 2017/8/27
 */
package top.zhaohaoren.generic;

import java.util.ArrayList;

/**
 * 泛型
 * 泛型其实是一种对容器的约束，限制容器中存储的类型只能是制定类型和其子类类型
 * 提高安全性，存入错误的类型在编译时就报错！
 *
 * 注意：
 * 对于程序来说，只有两种错：编译时候错，运行时错误，至于在IDE上那些属于静态代码检查，是IDE自己定义的一套约束！
 *
 * 泛型通配符： ？
 *      向下限定: ? extends E
 *      向上限定：? super E
 */
public class GenericDemo {
    public static void main(String[] agrs) {
//        ArrayList arr = new ArrayList(); //最初我们可以这样写
//        ArrayList<String> arr = new ArrayList<String>(); //制定泛型后我们可以这样写
        ArrayList<String> arr = new ArrayList<>(); //jdk1.7以后我们可以这样写： 菱形泛型:前面制定了就没必要在后面再写了

        arr.add(new String("a"));
//        arr.add(1); // 制定泛型后就不能随便添加对象了，只能添加其子类对象，所以泛型的类别制定Object是没有意义的。


        //: 泛型通配符 ？
        ArrayList<?> arrs = new ArrayList<String>();
        // 当右边不确定会制定给哪种类型的时候可以使用<?> 统配所有可能的类型。

        // ? 向下限定： 制定泛型后的容器中只能接受该类以及其子类类型。
        // collection.addAll(Collection<? extends E> c) <--集合的addAll()方法定义
        ArrayList<Object> olist = new ArrayList<>();
        ArrayList<String> slist = new ArrayList<>();
        olist.addAll(slist);
        // 因为泛型只会确定传入的类型是否等于容器制定的泛型，所以如果没有? extends E(这里E为String)，那么String是不可以赋给Object的
        // ? extends E 用？ 通配了所有E的子类类型，限定了容器可以接受的参数为E的子类类型。

        // ? 向上限定
        // TreeSet介绍

    }
}
