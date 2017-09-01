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
 * GenericDemo Create on 2017/8/27
 */
package top.zhaohaoren.generic;

import java.util.*;

/**
 * 泛型
 * 泛型其实是一种对容器的约束，限制容器中存储的类型只能是制定类型和其子类类型
 * 提高安全性，存入错误的类型在编译时就报错！
 * <p>
 * 注意：
 * 对于程序来说，只有两种错：编译时候错，运行时错误，至于在IDE上那些属于静态代码检查，是IDE自己定义的一套约束！
 * <p>
 * 泛型通配符： ？
 * 向下限定: ? extends E
 * 向上限定：? super E
 */
public class GenericDemo {
    public static void main(String[] agrs) {
//        ArrayList arr = new ArrayList(); //最初我们可以这样写
//        ArrayList<String> arr = new ArrayList<String>(); //制定泛型后我们可以这样写
        ArrayList<String> arr = new ArrayList<>(); //jdk1.7以后我们可以这样写： 菱形泛型:前面制定了就没必要在后面再写了

        arr.add(new String("a"));
//        arr.add(1); // 制定泛型后就不能随便添加对象了，只能添加其子类对象，所以泛型的类别制定Object是没有意义的。


        //: 泛型通配符 ？
        ArrayList<?> arrs = new ArrayList<String>();
        // 当右边不确定会制定给哪种类型的时候可以使用<?> 统配所有可能的类型。


        ArrayList<C> al = new ArrayList<C>();
        al.add(new C());
        List<? extends A> list = al;
//        list不允许加入任何元素
//        list.add(new A());
//        list.add(new B());
//        list.add(new C());
//        list可以获取元素，但是接受元素必须是A，是其他的会报错！
        A a1 = list.get(0);
//        C c1 = list.get(0);


        List<? super C> list1 = new ArrayList<B>();
//        list不允许加入C的父类元素
//        list1.add(new A());
//        list1.add(new B());
        list1.add(new C()); //可以添加C和C的子类
//        list获取元素需要强制类型转换，因为类信息使用list会被丢失
//        C c2 = list1.get(0);
        C c2 = (C)list1.get(0);
        /**
         *  结论：
         *  ? extends E
         *  add： 不允许加入 任何 元素！
         *  get： 可以获取元素，但是必须使用 E 来接受元素！
         *
         *  ? super E
         *  add: 允许添加 E和E的子类 元素！
         *  get: 可以获取元素，但是类的信息丢失了，所以返回只能使用Object引用来接受！如果需要自己的类型需要强制类型转换！
         *
         *  分析：
         *  时刻记住： 编译器使用list的时候，只知道list的泛型参数范围(?,E]，至于他后面指向了什么编译器不知道，list自己是什么类型也不确定。
         *  因为运行时候，不会再list上标记后面指向的ArrayList的类型，而是用一个capture#1来标记（原理暂时还不知道）。
         *
         *  由上，你使用list的时候，编译器所能获取的信息只有一个，list的泛型参数范围：(?,E] 或者 [E,?)
         *  所以如果允许get或者add，为了安全一定要进行类型判断，保证类型安全！这些判断的依据来源也只有该参数范围！
         *  那么问题来了： 我只知道(?,E] 或者 [E,?)的范围，不知道后面ArrayList具体是什么？所以我做出的决策只能是规定：
         *  只允许 E的父类 或者 E的子类 的对象添加！
         *  （因为list不确定自己的类型，只知道自己的范围，所以它对应的可add对象的范围一定是这个泛型参数范围内无论取哪种类型都能保证add是类型安全的）
         *  但是最终我们是要add进入ArrayList的，所以这个范围一定要ArrayList无论指定任何类型，都是类型安全的！
         *
         *
         *  ## ? extends E ##
         *  List < ? extends A > 表示 这个list里面存的是A的子类，具体是啥不知道，只知道范围！
         *  可以分两个范围： A子类，A父类。
         *      add：
         *      A子类情况：如果你允许add的元素是A的子类，那么因为泛型参数限定? extends A，所以ArrayList可以指定的类型也是A的子类，
         *      那么无法保证add的对象一定ArrayList指定类型的子类对象： ArrayList指定C,add了A()对象--这就是非法的！（因为list并不知道指定了C，
         *      它可以确定的范围就是可以add所有A的子类。）所以A子类不行！
         *      A父类情况：ArrayList指定类型肯定实在(?,A]范围内，所以这种情况肯定不行！
         *      get:
         *      list不知道你存入ArrayList是什么类型，但是我可以确定使用A的引用肯定可以接受ArrayList中的元素（无论ArrayList设定什么类型），
         *      因为A肯定是里面元素的父类！但是你使用其他类型接受就不行了，因为如果ArrayList的类型是你指定的那个类型的父类，是接受不了的。
         *
         *   ## ? super E ##
         *  List < ? super C > 表示list里面存的是C和其父类，具体是啥不确定，只知道范围
         *  同样的分为：C子类，C父类。（其实应该发现了没必要分为两类，有一类是肯定不行的）
         *      add：
         *      C子类：如果允许add，就允许list来add任何C的子类元素，因为ArrayList指定的范围是C和其父类，所以ArrayList可以准确接受该假设范围的所有对象
         *      所以，C子类这个范围可行，这样就有一个标准的类型判断依据，不像extends，根本无法确定判断标准，编译器就不会知道怎么做。
         *      C父类：显然和上面A子类情况是一样的！因为list无法知道ArrayList指定类型 ，所以无法确定判断标准。
         *      get:
         *      因为list只允许add C的子子类对象，你或许也在想：那我直接用C不就可以接受ArrayList数据吗？并不是的，ArrayList在赋给list之前
         *      可能里面已经有值了，这个值的类型如果是ArrayList指定类型，并且是C的父类，那么C就无法接受！
         *      而且list不知道ArrayList会指定哪个类型，只知道范围，所以无法确定是哪个父类，所以干脆用Object那肯定就能接受了，
         *      所以返回的其实只有Object能接受，否则就得强转。
         *
         *  其实最初我疑虑点就在为啥我不能限定他只添加ArrayList制定范围之后的那个呢?
         *  ----原因很简单，编辑器使用list的时候不知道ArrayList是啥！
         *  后来又纳闷为啥super没毛病同样也不知道啊为啥可以add？
         *  ----因为即便是super的时候，也是不知道的，super能add完全是靠常规逻辑判断！
         * */






    }
}

class A{}
class B extends A{}
class C extends B{}