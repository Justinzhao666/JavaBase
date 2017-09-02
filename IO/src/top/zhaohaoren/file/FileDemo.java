package top.zhaohaoren.file;/*
 * Copyright (c) 2017/9/2 by zhaohaoren
 * Welcome to visit my site:
 *  
 *  www.zhaohaoren.top
 *
 * @ Project: JavaBase
 * @ Lan: Java
 * @ author zhaohaoren
 * @ version 1.0 
 * top.zhaohaoren.file.FileDemo Create on 2017/9/2
 */

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *  File类
 *
 *  file(String pathname)通过将给定路径名字符串转换为抽象路径名来创建一个新 file 实例。
 *  file(file parent, String child)根据 parent 抽象路径名和 child 路径名字符串创建一个新 file 实例。
 *  file(String parent, String child)根据 parent 路径名字符串和 child 路径名字符串创建一个新 file 实例。
 *
 *  常用函数：
 *  createNewFile:创建文件
 *  mkdir：创建路径
 *  mkdirs：递归创建路径
 *  renameTo：将文件重命名到指定路径，路径相同改名，路径不同就剪切
 *  delete：删除文件或者文件夹--- 删除文件夹必须是删除空文件夹，想要全删除就遍历删除目录下文件在删除该文件夹
 *
 *  常用File的判断
 *
 *  File类常用获取
 *
 *
 *
 */
public class FileDemo {
    public static void main(String[] agrs) throws IOException {

        //file("也可以接受路径，java中路径也是文件") Java默认相对路径的根路径在项目的跟路径，也就是这个JavaBase的项目下
        File file = new File("F:\\Java\\JavaBase\\IO\\src\\test.txt");
        System.out.println(file.exists());

        //: 这样可以是路径下文件可以方便切换，比如遍历路径的时候使用！
        String parent = "F:\\Java\\JavaBase\\IO\\src";
        String child = "top/zhaohaoren/file/test.txt";
        File file1 = new File(parent,child);
        System.out.println(file1.exists());

        //: 可以parent路径使用File对象的方法。
        File file2 = new File(parent);
        File file3 = new File(file2,child);
        System.out.println(file3.exists());

        //：File创建功能
        fileFunctions();

        //：File判断功能
        fileJudge();

        //：File的获取功能
        fileGet();
    }


    public static void fileFunctions() throws IOException {
        //创建文件
        File file = new File("zhaohaoren.txt");
        file.createNewFile();

        //创建文件夹
        File dir = new File("test_dir");
        dir.mkdir();
        dir.delete();

        //创建文件夹，多级递归
        File dir2 = new File("test_dir/dir2");
        dir2.mkdirs();
        dir2.delete();
    }

    public static void fileJudge(){
        File file = new File("ccc");
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
        file.setReadable(false); //windows认为所有文件都是可读的，所以设置不会生效
        System.out.println(file.canRead());
        file.setWritable(true); //windows可以设置文件是可写的。
        System.out.println(file.canWrite());
        System.out.println(file.isHidden());
    }

    public static void fileGet(){

        File file = new File("F:\\Java\\JavaBase\\IO\\src\\test.txt");
        //获取绝对路径
        System.out.println(file.getAbsoluteFile());
        //获取File对象所传路径
        System.out.println(file.getPath());
        //获取文件或者文件名
        System.out.println(file.getName());
        //获取文件字节个数
        System.out.println(file.length());
        //获取最后修改时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH:mm:ss");
        System.out.println(sdf.format(new Date(file.lastModified())));

        File file2 = new File("F:\\Java\\JavaBase\\IO\\src");
        //获取文件夹下所有文件名称返回String[]
        System.out.println(file2.list().length);
        //获取文件夹下所有文件对象返回File[]---如果想要递归文件夹下的文件夹，最好使用这个可以判断File对象是不是路径咧
        System.out.println(file2.listFiles().length);

    }
}
