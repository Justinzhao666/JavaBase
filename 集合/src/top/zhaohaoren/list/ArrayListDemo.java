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
 * ArrayListDemo Create on 2017/8/27
 */
package top.zhaohaoren.list;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 删除ArrayList中的重复元素
 * 思路：
 * 1. 创建新数组
 * 2. 遍历旧数组
 * 3. 判断是否包含，如果不包含就加入
 *
 *
 * 重点：ArrayList的两个方法
 * contain方法
 * remove方法
 * 这两个方法源码都是通过当前对象传递给object来使用equal来比较之后操作的，
 * 所以自己定义的类对象，判断相等需要重写equals方法！！
 */
public class ArrayListDemo {
    public static void main(String[] agrs) {

        ArrayList list = new ArrayList();
//        list.add(new String("a"));
//        list.add(new String("a"));
//        list.add(new String("b"));
//        list.add(new String("c"));
        list.add(new MyClass("justin",10));
        list.add(new MyClass("justin",10));
        list.add(new MyClass("zhaohaoren",11));
        list.add(new MyClass("zhao",10));


        ArrayList newlist = ArrayListDemo.getSingle(list);
        System.out.println(newlist);

    }

    public static ArrayList getSingle(ArrayList arr){
        ArrayList arrayList = new ArrayList();
        Iterator ite = arr.iterator();
        while (ite.hasNext()){
            //String str = (String)ite.next(); // String类自己重写了equal方法没有问题

            MyClass str = (MyClass)ite.next();
            if (!arrayList.contains(str)){
                // contain 源码是使用 o.equal()方法来实现的，
                // 然而在Object中equal其实比较的是地址，所以这里会一直都是true
                // 需要重写该类的equals方法
                arrayList.add(str);
            }
        }
        return arrayList;
    }
}

class MyClass{


    String name;
    Integer age;

    public MyClass(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString() {
        return "MyClass{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyClass myClass = (MyClass) o;

        if (name != null ? !name.equals(myClass.name) : myClass.name != null) return false;
        return age != null ? age.equals(myClass.age) : myClass.age == null;
    }
}