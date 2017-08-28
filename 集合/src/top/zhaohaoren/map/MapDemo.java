/*
 * Copyright (c) 2017/8/28 by zhaohaoren
 * Welcome to visit my site:
 *  
 *  www.zhaohaoren.top
 *
 * @ Project: JavaCode
 * @ Lan: Java
 * @ author zhaohaoren
 * @ version 1.0 
 * MapDemo Create on 2017/8/28
 */
package top.zhaohaoren.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Map<K,V> 是一个接口
 *
 * HashSet底层是基于HashMap的，Set的底层是Map，只不过Set的Value部分设置为new Object()并显示被隐藏。
 *          HashSet                 HashMap
 *      k1 | new object()       k1  | value1
 *      k2 | new object()       k2  | value2
 *      k3 | new object()       k3  | value3
 *      k4 | new object()       k4  | value4
 *
 *  Map：
 *  map不是集合，不属于集合框架，因为他是键-值对的结构，不是结合的单列结构。所以它也不具有collection共有的方法。
 *
 *  方法：
 *  put(K,V) : 返回 被覆盖的值
 *  remove(K) : 由键删除，返回被删除的K的值
 *  clear() : 清空Map
 *  containsKey(K) : 是否包含键
 *  containsValue(V) : 是否包含值
 *  isEmpty() : 判断是否为空
 *  size() : map的大小
 *  get(K): 根据键获取值
 *  entrySet() : entry条目的意思，返回map的键-值对对象的一个set集合Set
 *
 *  特性：
 *  键是唯一的，值是可以重复的；
 *  存取无序，基于hash算法的存取；
 *
 *  遍历：
 *  无迭代器，不能迭代的。
 *  1. 转换为set iterator取值
 *  2. 转换为set foreach取值
 *  3. 转换为K-V对的set 进行迭代取值
 */
public class MapDemo {
    public static void main(String[] agrs) {
        //: map内置函数
        mapBuildInFunction();

        Map<String,Integer> map = new HashMap<>();
        map.put("张三",23);
        map.put("李四",24);
        map.put("王五",25);
        map.put("赵六",26);

        //: map迭代方式1
        mapIterator1(map);

        //: map迭代方式2 --推荐，两种其实都是一样，但是foreach更简洁
        mapIterator2(map);

        //: map迭代方式3 -- 更推荐，使用entrySet返回map键值对对象set的方式
        mapIterator3(map);

        //:存入自定义对象的时候
        Map<Student,Integer> map2 = new HashMap<>();
        map2.put(new Student("zhao",20),100);
        map2.put(new Student("zhao",20),100);
        map2.put(new Student("qian",22),90);
        map2.put(new Student("sun",23),80);
        map2.put(new Student("li",24),70);
        System.out.print(map2);


    }

    private static void mapIterator1(Map map) {

        Set<String> set = map.keySet(); //或获取所有的key
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.print("#"+map.get(iterator.next()));
        }
        System.out.println();

    }

    private static void mapIterator2(Map<String,Integer> map){

/*        Set<String> set = map.keySet();
        for (String s : set) {
            System.out.print("#"+map.get(s));
        }
        System.out.println();*/
        for (String s : map.keySet()) {
            System.out.print("#"+map.get(s));
        }
        System.out.println();
    }

    private static void mapIterator3(Map<String,Integer> map){

        // Set集合中存放的是Map.Entry对象:这是一个键-值对象: 有getkey()和getvalue()方法获取K,V。
        //使用set迭代器方式
        Set<Map.Entry<String, Integer>> set =  map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.print("#"+iterator.next().getKey());
        }
        System.out.println();
        // foreach
        for (Map.Entry<String,Integer> entry:map.entrySet()) {
            System.out.print("#"+entry.getValue());
        }
        System.out.println();
    }

    private static void mapBuildInFunction() {
        Map<String,Integer> map = new HashMap();
        map.put("a",1);
        map.put("b",1);
        map.put("c",1);
        map.put("d",1);
        Integer i = map.put("a",1);
        Integer j = map.remove("c");

        System.out.println(map);
        System.out.println(i);
        System.out.println(j);

        boolean iskey = map.containsKey("a");
        boolean isValue = map.containsValue(1);
        boolean isempty = map.isEmpty();
        System.out.println(iskey);
        System.out.println(isValue);
        System.out.println(isempty);
    }
}


class Student{
    private String name;
    private Integer age;

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    /**
     *  也是需要重写equals和hashcode方法的，当hashmap存入自定义对象的时候，会调用这两个函数来比较对象是否相等
     * */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (name != null ? !name.equals(student.name) : student.name != null) return false;
        return age != null ? age.equals(student.age) : student.age == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (age != null ? age.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}