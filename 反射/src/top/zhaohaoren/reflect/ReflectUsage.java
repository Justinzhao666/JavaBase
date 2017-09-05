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
 * ReflectUsage Create on 2017/9/5
 */
package top.zhaohaoren.reflect;

import top.zhaohaoren.bean.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 多态的一些实际用法：
 * <p>
 * 有参构造 反射来创建对象。获取class的构造并使用
 * getConstructor() 方法获取构造对象，然后使用构造对象来newInstance实际对象。
 * <p>
 * 获取class的字段信息，并使用
 * getField() 获取制定的字段
 * <p>
 * 获取class的方法信息，并使用
 * getMethod() 获取制定的方法
 */
public class ReflectUsage {
    public static void main(String[] args) throws Exception {
        getConstructor();
        getField();
        getMethod();
    }


    private static void getConstructor() throws Exception {
        Class clzz = Class.forName("top.zhaohaoren.bean.Person");
//        有参构造函数无法通过该方法创建对象。
//        Person p = (Person) clzz.newInstance();
        Constructor c = clzz.getConstructor(String.class, Integer.class); // 在知道参数的情况下
        Person p = (Person) c.newInstance("zhao", 23); // 创建对象
        System.out.println(p);
    }

    /**
     * 如果字段是私有的，使用getField无法直接获取的,
     * 但是在反射面前，类一切都是赤裸的：
     * 使用getDeclaredField可以获取类的指定private字段信息。
     * setAccessible()设置该字段可以访问
     * set(obj,obj): 修改对象，该字段的值
     */
    private static void getField() throws Exception {
        Class clzz = Class.forName("top.zhaohaoren.bean.Person");
        Constructor c = clzz.getConstructor(String.class, Integer.class);
        Person p = (Person) c.newInstance("zhao", 23);

//        Field f = clzz.getField("name");  无法获取class中的private字段
        Field f = clzz.getDeclaredField("name"); // 暴力反射
        f.setAccessible(true); // 设置可访问
        f.set(p, "justin"); // 将p对象的 name属性值修改为justin
        System.out.println(p);
    }

    private static void getMethod() throws Exception{
        Class clzz = Class.forName("top.zhaohaoren.bean.Person");
        Constructor c = clzz.getConstructor(String.class, Integer.class);
        Person p = (Person) c.newInstance("zhao", 23);

        Method m = clzz.getMethod("sayHello", String.class);
        m.invoke(p,"zhaohaoren"); // 让p对象执行sayHello方法

        Method m2 = clzz.getMethod("sayHello2");
        m2.invoke(p);
    }
}
