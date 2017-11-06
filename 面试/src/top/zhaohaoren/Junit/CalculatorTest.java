/*
 * Copyright (c) 2017/9/13 by zhaohaoren
 * Welcome to visit my site:
 *  
 *  www.zhaohaoren.top
 *
 * @ Project: JavaCode
 * @ Lan: Java
 * @ author zhaohaoren
 * @ version 1.0 
 * CalculatorTest Create on 2017/9/13
 */
package top.zhaohaoren.Junit;

import org.junit.*;

/**
 *  测试类 Junit单元测试
 *  1. 使用@Test注解
 *  2. 测试方法不可以有返回值
 *  3.测试方法不可以有参数
 *
 */
public class CalculatorTest {

    @Test
    public void testAdd(){
        Calculator cal = new Calculator();
        Assert.assertEquals(8,cal.add(3,5));
    }
    @Test
    public void testDiv(){
        Calculator cal = new Calculator();
        Assert.assertEquals(2,cal.div(4,2));
    }
}
