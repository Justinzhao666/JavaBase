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
 * TestEnum Create on 2017/9/5
 */
package top.zhaohaoren.枚举类;

import java.io.UnsupportedEncodingException;

/**
 *
 */
public class TestEnum {
    public static void main(String[] args) throws UnsupportedEncodingException {

        double i = 1.1/0;
        double i1 = 0.0/0;
        System.out.println(i);
        System.out.println(i1);
        System.out.println("a".getBytes("unicode").length);

        JDKEnum3 em = JDKEnum3.MON;
        System.out.println(em);

        /** 枚举类常用方法： **/
        System.out.println("枚举的编号:"+em.ordinal()); // 每个枚举都有编号int
        System.out.println(JDKEnum3.MON.compareTo(JDKEnum3.TUE)); //比较枚举编号，相减
        System.out.println(JDKEnum3.MON.toString()); // 调用枚举toString
        System.out.println(JDKEnum3.MON.name()); // 枚举的实例名：即为变量名
        JDKEnum3 em2 = JDKEnum3.valueOf(JDKEnum3.class,"MON"); //通过字节码class文件获取MON对象
        System.out.println(em2);
        JDKEnum3[] ems = JDKEnum3.values(); //获取枚举类中的所有枚举对象，方便用于遍历
        for (JDKEnum3 aem: ems) {
            System.out.print(aem+" ");
        }
        System.out.println();


        switch (em) {
//            case JDKEnum3.MON:
//            枚举case中的类型是em相同类型，所以不需要加上JDKEnum3
            case MON:
                System.out.println("1");
                break;
            case TUE:
                System.out.println("2");
                break;
            case WED:
                System.out.println("3");
                break;
            default:
                break;
        }

    }
}
