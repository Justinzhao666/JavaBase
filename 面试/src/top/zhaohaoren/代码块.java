/*
 * Copyright (c) 2017/11/5 by zhaohaoren
 * Welcome to visit my site:
 *  
 *  www.zhaohaoren.top
 *
 * @ Project: JavaCode
 * @ Lan: Java
 * @ author zhaohaoren
 * @ version 1.0 
 * 代码块 Create on 2017/11/5
 */
package top.zhaohaoren;

/**
 *  静态代码块 只执行一次，在类加载的时候执行
 *
 *  构造对象的时候，先执行构造代码块，然后再执行构造函数
 *
 */
public class 代码块 {

    static {
        System.out.println("Demo2_Student静态代码块");
    }


    public static void main(String[] args) {
        System.out.println("我是main方法");

        Student s1 = new Student();
        Student s2 = new Student();
    }
}


class Student {
    static {
        System.out.println("Student 静态代码块");
    }

    {
        System.out.println("Student 构造代码块");
    }

    public Student() {
        System.out.println("Student 构造方法");
        {
            int i =10;
            System.out.println("局部代码块");
        }
    }
}

/* 输出
Demo2_Student静态代码块
我是main方法
Student 静态代码块
Student 构造代码块
Student 构造方法
Student 构造代码块
Student 构造方法
* */