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
 * Switch_Case Create on 2017/8/28
 */

/**
 *  switch-case :
 *
 *  switch会逐个去匹配case项目，匹配不到就执行default（没有就不执行）
 *  如果没有break会自动往下执行。
 *
 */
public class Switch_Case {
    public static void main(String[] agrs) {

        int type =4;
        switch (type) {
            case 1:
                System.out.println(1);
            default:
                System.out.println(4);
            case 2:
                System.out.println(2);
            case 3:
                System.out.println(3);
        }
    }
}
