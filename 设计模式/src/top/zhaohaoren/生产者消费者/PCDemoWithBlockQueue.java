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
 * PCDemoWithBlockQueue Create on 2017/11/6
 */
package top.zhaohaoren.生产者消费者;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 *  阻塞队列实现：
 *
 *  jdk1.5之后提供了阻塞的队列BlockingQueue
 *  本身就提供了阻塞的方法：put()和take()方法用来从队列中取出和存入数据。不需要使用传统的wait和notify通信。
 *  注意：只有put和take方法是阻塞的，该队列还有add方法这些这些不是阻塞的。
 *
 *  该接口有两个实现：ArrayBlockingQueue和LinkedBlockingQueue
 */
public class PCDemoWithBlockQueue {
    public static void main(String[] args) {

        //这个就是 中间的缓冲队列，是P和C共享的一个队列 ----阻塞队列，调用take或者put方法的时候，如果队列环境不满足就阻塞操作
        BlockingQueue commonQueue = new LinkedBlockingQueue();

        P p = new P(commonQueue);
        C c = new C(commonQueue);
        new Thread(p).start();
        new Thread(c).start();
    }
}



class P implements Runnable{

    private final BlockingQueue commonQueue;

    public P(BlockingQueue commonQueue) {
        this.commonQueue = commonQueue;
    }

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            try {
                System.out.println("生产者 --- 生产:"+i);
                commonQueue.put(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class C implements Runnable{

    private final BlockingQueue commonQueue;

    public C(BlockingQueue commonQueue) {
        this.commonQueue = commonQueue;
    }

    @Override
    public void run() {
        while (true){
            try {
                System.out.println("消费者 --- 消费:"+commonQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
