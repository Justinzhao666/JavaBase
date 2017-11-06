/*
 * Copyright (c) 2017/11/3 by zhaohaoren
 * Welcome to visit my site:
 *  
 *  www.zhaohaoren.top
 *
 * @ Project: JavaCode
 * @ Lan: Java
 * @ author zhaohaoren
 * @ version 1.0 
 * J02BufferDemo Create on 2017/11/3
 */
package top.zhaohaoren.NIO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;

/**
 *
 * 几种buffer：
     ByteBuffer
     MappedByteBuffer
     CharBuffer
     DoubleBuffer
     FloatBuffer
     IntBuffer
     LongBuffer
     ShortBuffer
 *
 * buffer其实就是一块内存，可以往里面写东西，也可以从里面读东西。是一个数组可以为byte long等类型
 * buffer三个属性
 *      capacity：表示buffer的大小值
 *      position：
 *                  写模式下： 标记当前可写入的位置，写一个往后移动一个
 *                  读模式下： 重新置为0，然后开始从0位置开始读取，读一个position往后移一个
 *      limit：
 *                  写模式下：表示最多往buffer写入多少数据，= capacity
 *                  读模式下：表示我最多读多少数据,就是写模式下position的位置
 */
public class J02BufferDemo {
    public static void main(String[] args) throws IOException {

        RandomAccessFile aFile = new RandomAccessFile("./data.txt","rw");
        FileChannel inChannel = aFile.getChannel();

        //获取buffer
        CharBuffer buf = CharBuffer.allocate(1024);
        ByteBuffer buf2 = ByteBuffer.allocate(1024);

        // 向buffer中写入数据
        // 1:channel写
        int bytesRead = inChannel.read(buf2);
        // 2:put放
        buf.put('a');

        // 从Buffer中读取数据
        // 1: 将buffer读到channel中
        int byteWrite = inChannel.write(buf2);
        // 2: get方法
        byte abyte = buf2.get();


        buf.rewind(); //读模式下，将position重新置为0，limit不变，可以实现重读

        // 清空buffer:会让buffer清空，position置为0 ，limit置为capacity位置
        buf.clear();
        buf.compact();

        //标记该buffer中一个特殊的位置
        buf.mark();
        //reset回到上面标记的位置
        buf.reset();

        /*
            buffer的 equals方法，满足下面三个表示buffer相等。
                有相同的类型（byte、char、int等）。
                Buffer中剩余的byte、char等的个数相等。
                Buffer中所有剩余的byte、char等都相同。
         */

        /*
            compareTo()方法
            compareTo()方法比较两个Buffer的剩余元素(byte、char等)
            如果满足下列条件，则认为一个Buffer“小于”另一个Buffer：
                第一个不相等的元素小于另一个Buffer中对应的元素 。
                所有元素都相等，但第一个Buffer比另一个先耗尽(第一个Buffer的元素个数比另一个少)。
            【剩余元素是从 position到limit之间的元素】
        */
    }
}
