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
 * 内部类 Create on 2017/11/5
 */
package top.zhaohaoren;

import java.lang.reflect.Field;

/**
 * 内部类
 * 4种：
 * 1. 静态内部类
 * 2. 成员内部类
 * 3. 局部内部类
 * 4. 匿名内部类
 */
public class 内部类 {
    public static void main(String[] args) {
        Outer.Inner oi = new Outer().new Inner();
        oi.show();

    }
}

class Outer {
    public int num = 10;

    class Inner {
        public int num = 20;

        public void show() {
            int num = 30;
            System.out.println(num);
            System.out.println(this.num);
//            System.out.println(new Outer().num); 不是这样写的
            System.out.println(Outer.this.num); //内部类获取外部类的变量，--获取Outer.this的外部类的引用
        }
    }
}


class 外部类 {

    class 成员内部类 {

    }

    public void function() {

        final int 局部变量 = 1;

        class 局部内部类 {
            {
                System.out.println(局部变量);
                //局部内部类访问局部变量，应该讲局部变量申明为final，但是jdk1.8不需要了
            }
        }
    }
}