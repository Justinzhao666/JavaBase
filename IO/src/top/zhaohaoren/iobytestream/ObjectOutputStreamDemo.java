/*
 * Copyright (c) 2017/9/3 by zhaohaoren
 * Welcome to visit my site:
 *  
 *  www.zhaohaoren.top
 *
 * @ Project: JavaCode
 * @ Lan: Java
 * @ author zhaohaoren
 * @ version 1.0 
 * ObjectOutputStreamDemo Create on 2017/9/3
 */
package top.zhaohaoren.iobytestream;

import java.io.*;
import java.util.ArrayList;

/**
 * 对象操作流
 * ObjectOutputStream
 * ObjectInputStream
 * <p>
 * 将对象序列化存入文件，然后读取出来还原为对象
 */
public class ObjectOutputStreamDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        // 基本的一些对象流操作，问题： 因为不知道文件中写入了几个对象，如果不断读取文件的时候读结束了会排出EOF，文件末尾异常。
        fundmentalObjectStreamOperation();

        // 进一步优化，将对象都存入ArrayList中，然后将ArrayList对象写入文件。
        optimizeObjectStreamOperation();

    }

    private static void fundmentalObjectStreamOperation() throws IOException, ClassNotFoundException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("zhaohaoren.txt"));
        oos.writeObject(new MyClass("zhaohaoren", 20));
        oos.writeObject(new MyClass("justin", 24));
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("zhaohaoren.txt"));
        MyClass m1 = (MyClass) ois.readObject();
        MyClass m2 = (MyClass) ois.readObject();
        System.out.println(m1);
        System.out.println(m2);
        ois.close();
    }

    private static void optimizeObjectStreamOperation() throws IOException, ClassNotFoundException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("zhaohaoren.txt"));


        ArrayList<MyClass> al = new ArrayList<>();
        al.add(new MyClass("zhaohaoren", 20));
        al.add(new MyClass("justin", 24));
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("zhaohaoren.txt"));
        ArrayList<MyClass> al1 = (ArrayList<MyClass>) ois.readObject();
        System.out.println(al1);
        ois.close();
    }
}

class MyClass implements Serializable {
    public MyClass(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    String name;
    Integer age;
}
