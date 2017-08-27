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
 * 重写equals方法和hashcode方法    (使用IDE自己生成的就好了)
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
         *  1. 调用对象hashCode方法生成对象的hash值，判断集合中是否有相同的hash值对象
         *         如果没有，直接将对象存入集合（需要根据hash值分配地址）；
         *              ---所以我们重写hashcode方法的时候也要保证相同对象的hashcode一定是一样的！
         *              ---我们要保证的是不同的对象，他们的hashcode重复率低！
         *         如果有，调用equals与set中每一个对象做比较
         *  2. 调用equals方法
         *         如果相等，返回不能存入（所以要重写hashCode方法优化到重复率很低，减少equals调用次数）
         *         如果不等，说明这是两个不同的对象，存入同一个hash值得那个数据桶里面
         *  # 也就是说set判断是否有重复元素是根据hashCode和equals方法共同决定的。是否重写hashCode就看调用中是否会调用到对象的hashCode函数
         *  # 一般默认习惯给这两个都重写了！
         *
         *  如果不重写hashcode：
         *      调用Object的hashcode，计算对象的hashcode基本不一样，都直接存入了set中去了，不做equals比较。
         *  如果不重写equals
         *      当hashcode因为偶然原因计算不同对象的结果是一致的，那么调用Object的equals是比较的地址，所以他们的值也不一样，所以重复的也会被存入。
         *  总结：
         *  hashcode作用：1.计算hash值存入内存用，2. 初步筛选相同数据工作（hash存在重复概率，不能单纯依靠hashcode函数来区别是否相同）
         *  equals作用：对hashcode函数筛选出来的数据进一步做判别！因为hashcode只能返回int，我们不能直接使用字符串比较，所以equal比较后肯定确保存入数据不会重复
         *
         *  之所以这么烦，就是因为set存入的时候非要调用hashcode（应该是用于计算存入内存地址），这个函数还不能100%判别对象是不是相等的。
         * */
        HashSet<Person> hsp = new HashSet<>();
        hsp.add(new Person("zhao", 20));
        hsp.add(new Person("zhao", 20)); //-
        hsp.add(new Person("li", 20));
        hsp.add(new Person("qian", 21));
        hsp.add(new Person("sun", 20));
        hsp.add(new Person("sun", 20)); //-
        hsp.add(new Person("zhao", 22));
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

        /**
         * hashcode是很容易重复的
         * hash运算的重复，以及下面两个数字虽然各自都不同，但是相加后就可能相同了
         *
         * 为什么这里是31
         * 1. 31是质数，只能被1和其自身整除，如果是其他的数，那么这个数又可能被其他数的组合凑成相同的。
         * 2. 数字不大不小，太大了前面部分没有意义，加不到。
         * 3. 好算：是2^5-1，方便计算机位运算
         * */
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (age != null ? age.hashCode() : 0);
        return result;
    }
}

