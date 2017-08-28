/*
 * Copyright (c) 2017/8/29 by zhaohaoren
 * Welcome to visit my site:
 *  
 *  www.zhaohaoren.top
 *
 * @ Project: JavaBase
 * @ Lan: Java
 * @ author zhaohaoren
 * @ version 1.0 
 * StringCount Create on 2017/8/29
 */

import java.util.HashMap;

/**
 *  统一一个字符串中字符出现的个数
 *
 *  利用HashMap只能存储唯一key的特性来判断一个字符出现几次！
 */
public class StringCount {
    public static void main(String[] agrs) {

        String str = "aaaadddscccdsfff";
        char[] chars = str.toCharArray();

        HashMap<Character,Integer> hm = new HashMap<>(); //Map<K,V> KV作为泛型只接受非基本数据类型

        for (char c: chars) {
//            if (hm.containsKey(c)){
//                hm.put(c,hm.get(c)+1);
//            }else {
//                hm.put(c,1);
//            }
            hm.put(c,hm.containsKey(c)?hm.get(c)+1:1);
        }

        for (Character c:hm.keySet()) {
            System.out.println("key:"+c +" value:"+hm.get(c));
        }


    }
}
