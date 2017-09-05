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
 * Demo01 Create on 2017/9/5
 */
package top.zhaohaoren.demo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 *  反射越过 泛型检查
 *
 *  通过反射可以修改对象的方法：指定泛型为Integer的list获取原类的方法，可以向一个指定Integer泛型的容器加入String等类型
 *
 */
public class Demo01 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        ArrayList<Integer> list = new ArrayList<>();
        list.add(111);
        list.add(222);

        Class c = Class.forName("java.util.ArrayList");
        Method m = c.getMethod("add", Object.class); // 这里获得的方法里面的参数不会是Integer，所以可以添加String
        m.invoke(list,"zhaohaoren");

        System.out.println(list);

    }
}
