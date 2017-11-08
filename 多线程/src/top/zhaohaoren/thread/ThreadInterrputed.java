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
 * ThreadInterrputed Create on 2017/11/6
 */
package top.zhaohaoren.thread;

/**
 * 线程中断
 * <p>
 * stop线程是暴力中断！ ---方法过期
 * interrupt() 使用该方法中断线程，优雅的中断！---这个方法只是修改标志位，并不会真正的终止线程！
 * <p>
 * <p>
 * 每一个线程对象内部都有一个boolean标志位，标记当前线程是否被中断，被中断设置为true，没有被设置为false
 * Thread.currentThread().isInterrupted() 可以判断当先线程的是否被中断。
 *
 * 当其他线程调用interrupt的时候有两种情况：
 * 1. 当前线程处于低级的阻塞状态：比如调动Thread.sleep()、 Thread.join() 或 Object.wait()，此时会取消阻塞并抛出InterruptedException异常
 * 2. 当前线程还在运行，没有被阻塞：只是改变下标志位并没有实际终止线程。
 *
 *
 * 有一种情况是线程不能被中断的，就是调用synchronized关键字和reentrantLock.lock()获取锁的过程。
 * 如果调用带超时的tryLock方法reentrantLock.tryLock(longtimeout, TimeUnit unit)，那么如果线程在等待时被中断，将抛出一个InterruptedException异常，
 * 是一个非常有用的特性，因为它允许程序打破死锁。
 */
public class ThreadInterrputed {
    public static void main(String[] args) {

    }


    class MyThread extends Thread {
        @Override
        public void run() {
            super.run();
            try {
                for (int i = 0; i < 500000; i++) {
                    if (this.interrupted()) {
                        System.out.println("检测到中断，应该中断线程了");
                        throw new InterruptedException(); //抛出异常
                    }
                    System.out.println("i=" + (i + 1));
                }
                System.out.println("this line cannot be executed. cause thread throws exception");
            } catch (InterruptedException e) {
                /**这样处理不好
                 * System.out.println("catch interrupted exception");
                 * e.printStackTrace();
                 */
                // 针对异常重新中断
                Thread.currentThread().interrupt();//这样处理比较好--让异常扩散出去。
            }
        }
    }
}

