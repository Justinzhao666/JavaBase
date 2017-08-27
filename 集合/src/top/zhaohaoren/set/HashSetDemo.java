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
 * HashSetDemo Create on 2017/8/27
 */
package top.zhaohaoren.set;

import java.sql.SQLSyntaxErrorException;
import java.util.HashSet;

/**
 * Set几个特性：
 * 1、无序，存取结果不一致
 * 2、数据不可以重复
 * 3、没有索引
 * <p>
 * 这都是因为存储形式是做hash映射的，所以无法做到上面这些特性
 * <p>
 * HashSet存入自定义对象
 * 重写equals方法和hashcode方法
 * --- 在向set中存入自定义类的对象数据时候以及过程会调用对象的hashCode方法的时候才有必要重写！
 */
public class HashSetDemo {
    public static void main(String[] agrs) {


        /** HashSet存入非自定义对象 */
        HashSet<String> hs = new HashSet<>();
        boolean b1 = hs.add("a");
        boolean b2 = hs.add("a"); // 数据不可重复
        hs.add("b");
        hs.add("c");
        hs.add("d");
        hs.add("e"); // 无序，存取不一致
        System.out.println(b1); //hashset有重写toString方法
        System.out.println(b2);
        System.out.println(hs);

        for (String s : hs) {
            System.out.print(s);
        }

        /** HashSet存入自定义对象 */
        /**
         *  当向集合放入对象的时候：
         *  1. 调用对象的hashCode方法，初步判断对象是否相等！
         *         如果不等，直接将对象直接分配地址存入（需要根据hash值分配地址）；
         *         如果相等，调用equals方法
         *  2. 调用equals方法
         *         如果相等，返回不能存入（所以要重写hashCode方法优化到重复率很低，减少equals调用次数）
         *         如果不等，说明这是两个不同的对象，存入同一个hash值得那个数据桶里面
         *  # 也就是说set判断是否有重复元素是根据hashCode和equals方法共同决定的。是否重写hashCode就看调用中是否会调用到对象的hashCode函数
         *  # 一般默认习惯给这两个都重写了！
         *
         *  如果不重写，或者只重写equals
         *  最先调用hashCode函数的时候，使用的Object方法（是native方法），那些对象计算出来的结果基本都是不一样的，
         *  所以就不会再去调用equals方法，直接存入set中去，那么你重写的比较也就没有意义。
         *
         * */
        HashSet<Person> hsp = new HashSet<>();
        hsp.add(new Person("zhao",20));
        hsp.add(new Person("zhao",20)); //-
        hsp.add(new Person("li",20));
        hsp.add(new Person("qian",21));
        hsp.add(new Person("sun",20));
        hsp.add(new Person("sun",20)); //-
        hsp.add(new Person("zhao",22));
        System.out.println(hsp);
    }
}

class Person {
    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (name != null ? !name.equals(person.name) : person.name != null) return false;
        return age != null ? age.equals(person.age) : person.age == null;
    }

    @Override
    public int hashCode() {
        // 要尽量让不同对象hashCode计算的结果不同！
        // hashCode要做好优化。少写hashcode就少调用equals方法去比较。--这个IDE可以为我们自动生成
        // 因为如果相同就会去调用equals方法，来判断，然后再加入筒中，无疑影响性能。
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (age != null ? age.hashCode() : 0);
        return result;
    }
}

