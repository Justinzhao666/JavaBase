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
 * ReflectUsage Create on 2017/9/5
 */
package top.zhaohaoren.reflect;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * 多态转为用反射来实现
 *
 * 使用IO读取文件中配置的类信息，然后使用反射加载类。
 *
 * 好处：
 *      使用多态还是需要改代码才能实际不同类的切换
 *      如果使用反射只需要修改配置文件，不需要改动java文件就能对程序进行多态展现.
 *
 */
public class ReflectAndPolymorphic {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("反射/src/top/zhaohaoren/reflect/config"));
        Class clzz = Class.forName(br.readLine());
        Fruit f = (Fruit) clzz.newInstance();

        Machine machine = new Machine();
        machine.makeJuice(f);
    }
}

interface Fruit{
    public void juice();
}

class Apple implements Fruit{

    @Override
    public void juice() {
        System.out.println("Apple juice！");
    }
}

class Pear implements Fruit{

    @Override
    public void juice() {
        System.out.println("Pear juice！");
    }
}

class Machine{

    public void makeJuice(Fruit f){
        f.juice();
    }
}