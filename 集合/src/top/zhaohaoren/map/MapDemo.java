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
 *
 *  特性：
 *  键是唯一的，值是可以重复的；
 *  存取无序，基于hash算法的存取；
 *
 *  遍历：
 *  无迭代器，不能迭代的。
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
