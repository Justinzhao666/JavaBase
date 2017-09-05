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
 * MyEnum Create on 2017/9/5
 */
package top.zhaohaoren.枚举类;

/**
 * 自定义枚举类
 *
 * 枚举类的本质：
 * 1. 构造函数私有化，不能创建对象的类
 * 2. 枚举元素就是内置的几个静态变量，只不过因为特殊机制所以只写变量名。
 * 枚举类其实就是class的一种变形，本质上和class具有一致性。
 *
 * 枚举类是一个类，枚举元素是对象，使用枚举就是用枚举类引用来使用枚举元素对象。
 */

/**   基本枚举类：自定义枚举类型，构造方法私有化，枚举元素为内置对象，多个单例  **/
// 对应JDKEnum的JDKEnum1
class MyEnum1 {
    public final static MyEnum1 MON = new MyEnum1();
    public final static MyEnum1 TUE = new MyEnum1();
    public final static MyEnum1 WED = new MyEnum1();

    private MyEnum1(){}

}

/**   如果有构造参数，那么内置对象构造也要加上构造参数  **/
// 对应JDKEnum的JDKEnum2，枚举类中有参数，也要给枚举元素加上构造
class MyEnum2 {
    public final static MyEnum2 MON = new MyEnum2("1");
    public final static MyEnum2 TUE = new MyEnum2("2");
    public final static MyEnum2 WED = new MyEnum2("3");

    private String name;
    private MyEnum2(String name){
        this.name = name;
    }

}

/**   如果包含抽象方法，那么内置对象因为无法创建该对象的实例，所以用匿名内部类，让枚举元素指向匿名内部类  **/
// 对应JDKEnum的JDKEnum3，也要给枚举元素实现匿名内部类
abstract class MyEnum3 {
    public final static MyEnum3 MON = new MyEnum3("1"){
        @Override
        public void show() {
            System.out.println(super.name);
        }
    };
    public final static MyEnum3 TUE = new MyEnum3("2"){
        @Override
        public void show() {
            System.out.println(super.name);
        }
    };
    public final static MyEnum3 WED = new MyEnum3("3"){
        @Override
        public void show() {
            System.out.println(super.name);
        }
    };

    private String name;
    private MyEnum3(String name){
        this.name = name;
    }

    public abstract void show();
}
