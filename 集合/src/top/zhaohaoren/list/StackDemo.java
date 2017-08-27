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
 * StackDemo Create on 2017/8/27
 */
package top.zhaohaoren.list;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 1. 栈的主要使用
 * 2. linkedlist实现栈
 */
public class StackDemo {
    public static void main(String[] agrs) {
        Stack stack = new Stack();
        stack.push("a");
        stack.pop(); //线程安全的

        //: 自定义栈
        MyStack ms = new MyStack();
        ms.push("aa");
        ms.push("bb");
        ms.pull();
        System.out.println(ms);

    }
}


class MyStack {

    private LinkedList list = new LinkedList();

    public void push(Object o) {
        list.addLast(o);
    }

    public Object pull() {
        return list.removeLast();
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    @Override
    public String toString() {
        return "MyStack{" +
                "list=" + list +
                '}';
    }
}
