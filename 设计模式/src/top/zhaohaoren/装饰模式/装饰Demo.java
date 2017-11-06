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
 * 装饰Demo Create on 2017/11/5
 */
package top.zhaohaoren.装饰模式;

/**
 *  装饰动态添加职责
 *
 *  持有本身类基础上，我可以定制的针对不同情况写不同装饰而得到不同表现。
 */
public class 装饰Demo {
    public static void main(String[] args) {

        //装饰类这么使用
        // 将要被装饰的类放入到装饰类中去，原来的被装饰类就添加了其他功能！
        Common c = new DecorateClass(new OrginClass());
        c.function();

    }
}



interface Common{
    public  void function();
}

class OrginClass implements Common{

    @Override
    public void function() {
        System.out.println("我是要被装饰的类");
    }
}

class DecorateClass implements Common {

    OrginClass obj; //持有被装饰的类  <-

    public DecorateClass(OrginClass obj) {
        this.obj = obj;
    }

    //进行装饰
    @Override
    public void function() {
        System.out.println("装饰类装饰下");
        obj.function();
        System.out.println("装饰类装饰下");
    }
}