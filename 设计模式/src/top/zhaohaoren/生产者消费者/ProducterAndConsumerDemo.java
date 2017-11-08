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
 * ProducterAndConsumerDemo Create on 2017/11/6
 */
package top.zhaohaoren.生产者消费者;

import java.util.PriorityQueue;
import java.util.Queue;

import static java.lang.System.out;

/**
 * 生产者和消费者模型
 *
 * 使用notify和wait实现，原理也是一样 提供一个队列，然后判断队列状态来确定是wait还是notify
 * <p>
 * 模型中的成员： 生产者(线程)，消费者（线程），内存缓冲区(一般队列，共享内存)
 * <p>
 * 实际应用场景中生产者其实就是一堆线程，消费者也是一堆线程,
 * 需要做到：缓冲队列满了的时候，生产者需要等待，缓冲队列为空的时候，消费者需要等待。其他时间为动态平衡
 */
public class ProducterAndConsumerDemo {
    private int queueSize = 2;
    private Queue<Integer> queue = new PriorityQueue<>(queueSize);

    public static void main(String[] args) {
        ProducterAndConsumerDemo producterAndConsumerDemo = new ProducterAndConsumerDemo();
        Producter p = producterAndConsumerDemo.new Producter();
        Consumer c = producterAndConsumerDemo.new Consumer();
        new Thread(p).start();
        new Thread(c).start();
    }

    class Producter implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                synchronized (queue) { //只有操作共享数据的时候才开始同步
                    while (queue.size() == queueSize) {
                        try {
                            out.println("停止生产，等待消费者消费");
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            queue.notifyAll();
                        }
                    }
                    queue.offer(i);
                    System.out.println("生产者生产： " + i);
                    queue.notifyAll();
                }
            }
        }
    }

    class Consumer implements Runnable {

        @Override
        public void run() {
            while (true) {
                synchronized (queue) {
                    while (queue.size() == 0) {
                        try {
                            out.println("没有货物可以消费，等待！");
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            queue.notifyAll();
                        }
                    }
                    out.println("消费者消费：  " + queue.poll());
                    queue.notifyAll();
                }
            }
        }
    }
}




