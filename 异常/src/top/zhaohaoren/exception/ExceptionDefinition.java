/*
 * Copyright (c) 2017/9/1 by zhaohaoren
 * Welcome to visit my site:
 *  
 *  www.zhaohaoren.top
 *
 * @ Project: JavaCode
 * @ Lan: Java
 * @ author zhaohaoren
 * @ version 1.0 
 * ExceptionDefinition Create on 2017/9/1
 */
package top.zhaohaoren.exception;

/**
 *  自定义异常
 *
 *  让异常使用自己的名字，便于处理
 */
public class ExceptionDefinition {
    public static void main(String[] args) throws MyException {

        int i = 1;
        if (i<2){
            throw new MyException("aaa");
        }
    }
}

class MyException extends Exception {
    public MyException(String ... s) {
        System.out.println(s);
    }
}
