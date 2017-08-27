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
 * GenericDefinition Create on 2017/8/27
 */
package top.zhaohaoren.generic;

/**
 * 自己写一个泛型类
 *
 * 申明泛型 在类或或接口或方法加上<T>就ok
 *
 * 1. 类泛型
 * 2. 方法泛型
 *      非静态可以用自己泛型也可以不用
 *      静态方法必须申明自己的泛型
 * 3. 泛型接口
 */
public class GenericDefinition {
    public static void main(String[] agrs) {

        MyGeneric<String> mg = new MyGeneric<>();
        System.out.print(mg.getT());
    }
}

//:  泛型类
class MyGeneric<T>{ // 这里T就是指定该类的泛型，T可以用其他的字符Q/P/E等替代，表明意思就好。
    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

//: 泛型方法
    public <E>void function(E e){  // 泛型方法： 最好和类的泛型一致； 如果方法泛型和类的需要不一样需要在方法上申明泛型
        System.out.println(e);
    }

    public static <Q>void staticFunction(Q q){ //静态方法必须申明自己的泛型！！即使名字和类一样这两个泛型仍是不一样的。

    }
}

//: 泛型接口
interface Inter<T>{
    public void show(T t);
}
//： 推荐用这种方式来实现接口泛型，如果不指定，T会为Object
class MyInter implements Inter<String>{
    @Override
    public void show(String s) {

    }
}
//: 方法2： 自己也不指定泛型，由用户决定，不推荐！
class MyInter2<T> implements Inter<T>{

    @Override
    public void show(T o) {

    }
}