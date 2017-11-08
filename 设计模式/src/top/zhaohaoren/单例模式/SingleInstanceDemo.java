/*
 * Copyright (c) 2017/11/6 by zhaohaoren
 * Welcome to visit my site:
 *  
 *  www.zhaohaoren.top
 *
 * @ Project: JavaCode
 * @ Lan: Java
 * @ author zhaohaoren
 * @ version 1.0 
 * SingleInstanceDemo Create on 2017/11/6
 */
package top.zhaohaoren.单例模式;

/**
 *  应用场景：
 *
 *  网站计数器
 *  日志控制器
 *  web资源配置信息
 *
 */
public class SingleInstanceDemo {
    public static void main(String[] args) {

    }
}


// 饿汉式
class HungrySingleton{
    private static HungrySingleton hungrySingleton= new HungrySingleton();
    private HungrySingleton(){
    }
    public static HungrySingleton getInstance(){
        return hungrySingleton;
    }
}

//懒汉式 ----延迟加载思想
class LazySingleton{
    private static LazySingleton lazySingleton;
    private LazySingleton(){
    }
    public static LazySingleton getSingleInstance(){
        if (lazySingleton != null){
            return new LazySingleton();
        }
        return lazySingleton;
    }
}

//懒汉式安全：双重校验锁  ---只在jdk1.5以上安全，因为之前的volatile支持有问题。（还有一种同步方法 这里不提）
class LazySingletonSafe{
    // 重点1：记住这里加上volatile关键字。
    private volatile static LazySingletonSafe lazySingletonSafe;
    private LazySingletonSafe(){
    }
    //线程不安全处：会创建多个实例
    public static LazySingletonSafe getSingleInstance(){
        //重点2：
        if (lazySingletonSafe ==null){ //非必须
            synchronized (LazySingletonSafe.class){ //需要同步下面代码块，因为下面代码块造成执行的原子性缺失而线程不安全。
                if (lazySingletonSafe != null){  //必须
                    return new LazySingletonSafe();
                }
            }
        }
        /**
         * 为什么要双重校验锁：
         * 外面一层是为了节省性能
         * 里面一层判断null是为了保证单例
         *
         * 怎么保证了性能？
         * 如果没有外面的判断，每次线程执行都会判断是否可以获得锁，访问锁的操作太频繁了！
         * 对于某个线程如果刚好进来的时候，这个实例已经存在了的情况----那么还去尝试读锁就多余了，这时候就让其先判断下，这样就直接返回了。
         * 第二重校验主要目的就是为了让线程执行的时候发现实例已经存在的情况，不必去用锁！从而进一步减少性能的缺失。
         * */

        return lazySingletonSafe;
    }
}


//枚举类类型。最佳方式，支持自动序列化，绝对的防止了反序列化为对象时创建了多个对象！
enum EnumSingleton{
    INSTANCE;
    public void function(){

    }
}
