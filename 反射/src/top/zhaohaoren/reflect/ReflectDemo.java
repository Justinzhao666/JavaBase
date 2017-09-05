/*
 * Copyright (c) 2017/9/5 by zhaohaoren
 * Welcome to visit my site:
 *  
 *  www.zhaohaoren.top
 *
 * @ Project: JavaCode
 * @ Lan: Java
 * @ author zhaohaoren
 * @ version 1.0 
 * ReflectDemo Create on 2017/9/5
 */
package top.zhaohaoren.reflect;

import top.zhaohaoren.bean.Person;

/**
 * 反射就是获取字节码文件
 * 返回值类型是Class，代表字节码文件
 * <p>
 * 反射的作用：
 * 将来在使用框架的时候，因为框架里面的代码我们是不能改写的，所以使用反射来对类进行修改，使得类满足我们的需求。
 */
public class ReflectDemo {
    public static void main(String[] args) throws ClassNotFoundException {

        Class clzz1 = Person.class;
        /**
         * 作用：
         * 静态方法做同步锁使用
         * */

        Class clzz2 = new Person("z", 10).getClass();
        /**
         * 作用：
         * 判断对象是不是同一个字节码
         * */

        Class clzz3 = Class.forName("top.zhaohaoren.bean.Person");
        /**
         * 作用：
         * 读取配置文件，修改配置文件从而使其加载不同类文件
         * */


    }
}
