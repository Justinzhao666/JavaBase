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
 * FileCopy Create on 2017/9/3
 */
package top.zhaohaoren.iocharstream;

import java.io.*;

/**
 * 使用FileReader和FileWriter进行复制操作 --- 不推荐使用这个进行复制操作，应该使用字节流进行操作。
 * <p>
 * 1. 一个字符一个字符的读写
 * 2. 将字符传入一个char数组中然后整个数组的进行读写！
 * 3. BufferedReader和BufferedWriter
 * read() 和 write
 * readLine() 和 newLine()
 * 4. 指定编码表的读写：InputStreamReader，OutputStreamWriter
 */
public class FileCopy {
    public static void main(String[] args) throws IOException {
//        copyWithSingleChar();
        copyWithEncoding();
    }

    private static void copyWithSingleChar() throws IOException {
        FileReader fr = new FileReader("zhaohaoren.txt");
        FileWriter fw = new FileWriter("zhaohaorencopy.txt");

        int content;
        while ((content = fr.read()) != -1) {
            fw.write(content);
        }

        fw.close(); //一定要关流， FileWriter里面有一个2k的缓冲区，如果不关流，最后的2k里面的有效内容将无法刷新到文件中。
        fr.close();
    }

    private static void copyWithFixedBuffer() throws IOException {
        FileReader fr = new FileReader("zhaohaoren.txt");
        FileWriter fw = new FileWriter("zhaohaorencopy.txt");

        int len;
        char[] chars = new char[1024 * 2];
        while ((len = fr.read(chars)) != -1) {
            fw.write(chars, 0, len);
        }

        fw.close(); //一定要关流， FileWriter里面有一个2k的缓冲区，如果不关流，最后的2k里面的有效内容将无法刷新到文件中。
        fr.close();
    }

    private static void copyWithBuffered() throws IOException {
        /**
         * 内置缓冲区大小为 8192
         * **/
        BufferedReader br = new BufferedReader(new FileReader("zhaohaoren.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("zhaohaorencopy.txt"));

        int content;
        while ((content = br.read()) != -1) {
            bw.write(content);
        }

        bw.close();
        br.close();

    }

    private static void copyWithBufferedLine() throws IOException {

        /** readLine() 读取一行，遇到\n 和 \r 读取一行 返回String，如果结束返回null **/
        BufferedReader br = new BufferedReader(new FileReader("zhaohaoren.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("zhaohaorencopy.txt"));

        String content;
        while ((content = br.readLine()) != null) {
            bw.write(content);
            bw.newLine(); //加上回车换行，是跨平台的方法。
//            bw.write("\r\n");  只支持window系统，其他各个系统的换行符号是不同的。Linux是\n mac是\r
        }
        bw.close();
        br.close();
    }

    /**
     * 程序按照字节流去读取文件，然后将字节流根据指定的编码表转为字符，将字符存在Buffer中----读取
     * 程序将将buffer中的数据的字符根据指定编码表转成字节流，然后写入文件-----写入
     *
     * uft-8 一个中文占三个字节，
     * jbk一个中文占两个字节，这样读取和写入不一致的时候就会乱码。当编码表查询对应字节找不到的时候就返回?号
     * **/
    private static void copyWithEncoding() throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream("zhaohaoren.txt"), "utf-8");
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("zhaohaorencopy.txt"), "gbk");
//        BufferedReader br = new BufferedReader(isr);
//        BufferedWriter bw = new BufferedWriter(osw);
//        可以使用buffered做进一步装饰
        int c;
        while ((c= isr.read())!= -1){
            osw.write(c);
        }
        osw.close();
        isr.close();
    }

}
