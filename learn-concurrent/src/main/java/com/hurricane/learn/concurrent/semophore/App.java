package com.hurricane.learn.concurrent.semophore;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class App implements Runnable{
	
	static Semaphore semaphore = new Semaphore(10);
	static CountDownLatch latch = new CountDownLatch(20);
	public static void main(String[] args) {
		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(20);
		for (int i = 0; i < 20; i++) {
			newFixedThreadPool.submit(new App());
		}
		
		System.out.println("main");
		try {
			latch.await();
			System.out.println("all task end");
			newFixedThreadPool.shutdown();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void run() {
//		System.out.println(this);
		try {
			semaphore.acquire(5);
			System.out.println(Thread.currentThread().getName()+"---进入");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			semaphore.release(5);
			System.out.println(Thread.currentThread().getName()+"---退出");
			latch.countDown();
		}
		
	}
}
