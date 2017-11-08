/*    
 * ThreadCallable.java Create on 2017-8-20
 * @Description:   TODO
 *
 * @author zhaohaoren     
 * @version 1.0 
 * Copyright (c) 2017-8-20 by zhaohaoren      
 */
package top.zhaohaoren.threadcommuicate;

import java.util.concurrent.*;


/*
 * 第三中创建线程方式：
 * 线程池中加入callable方法，线程执行完可有返回值！
 *
 * 线程是异步的，所以无法直接从线程执行直接得到函数的返回值，所以Future产生了，它会一直监视call方法调用情况，
 * 当调用get()的时候，当前线程就开始阻塞，直接等到call方法结束返回结果。
 *
 * Callable的返回值可以被Future或者FutureTask获得。
 *
 * Future 有三个重要方法： get() get(timeout) cancel()
 * get是用于获取数据对象，如果数据没有加载会一直阻塞
 * get(timeout) 阻塞超时就不阻塞了，返回失败。
 * cancel用于取消数据加载。
 * 所以它可以用来获取到Callable的返回值！，在Callable线程没有执行完之前，它会一直阻塞着。
 *
 */
public class ThreadCallable {

	/**
	 * @param args
	 * @throws ExecutionException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		ExecutorService  pool = Executors.newFixedThreadPool(2);
		
		// pool submit 一个Callable对象返回一个Future 对象
		Future<Integer> f1 =  pool.submit(new MyCallable(10));
		
		// Future对象通过get方法获取值
		System.out.println(f1.get());

	}

	// 使用FutureTask来获得结果！
	public void baseUseCallable() throws ExecutionException, InterruptedException {
		//FutureTask f.get()就能获取到返回值。
		FutureTask<Integer> f = new FutureTask<Integer>(new MyCallable(10));
		//Thread 只接受Runnable参数，FutureTask实现了Runnable接口，所以Callable需要被包装一下。
		new Thread(f).start();
		System.out.println(f.get());
	}

}

class MyCallable implements Callable<Integer> {
	private int num;

	public MyCallable(int num) {
		this.num = num;
	}

	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		return num + 10;
	}
}