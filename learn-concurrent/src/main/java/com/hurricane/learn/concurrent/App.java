package com.hurricane.learn.concurrent;

import java.util.concurrent.locks.ReentrantLock;

public class App {
	static int i = 0;
	static ReentrantLock lock = new ReentrantLock();
	public static void main(String[] args) throws InterruptedException {
		Runnable runnable = ()->{
			for (int j = 0; j < 100000; j++) {
				lock.lock();
				try {
					i++;
				} finally {
					lock.unlock();
				}
//				增加下面这一行打印，会使得最后的结果输出趋向正确
//				System.out.println(Thread.currentThread().getName()+"---->"+i);
			}
		};
		Thread t1 = new Thread(runnable, "t1");
		Thread t2 = new Thread(runnable, "t2");
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(i);
	}
}
