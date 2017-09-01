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
 * Final_Fianlly_Finallize Create on 2017/9/1
 */

/**
 *  final finally finalize区别：
 *
 *  final ：
 *      修饰类，不能被继承
 *      修饰方法，不能被重写
 *      修饰变量，只能被赋值一次，赋值后不能修改
 *  finally ：
 *      用于异常try catch段用来释放资源的。
 *  finalize：
 *      是一个方法，当垃圾回收器确定不存在该对象的引用的时候，由对象的垃圾回收器调用该方法。
 *
 *  finally 在return前执行还是return后执行？：
 *      catch中return，finally也会执行，不过：
 *      finally在return之后执行，先return，在真正函数退出前再执行finally，然后继续执行return。
 */
public class Final_Finally_Finalize {
    public static void main(String[] args) {

        System.out.println(finallyAndReturn());
    }


//    finally 在return前执行还是return后执行？：
    public static Integer finallyAndReturn(){
        Integer  i = 1;

        try{
            i = 2;
            Integer j = 10/0;
            return  i;
        }catch (Exception ex){
            System.out.println(ex);
            i = 3;
            return i; //执行return的时候保存i=3的现场，执行finally，执行完后恢复现场return出函数
        }finally {
            i = 4; //finally只用于释放资源！ 不要加return！会覆盖try和catch中的return的
        }


    }

}
