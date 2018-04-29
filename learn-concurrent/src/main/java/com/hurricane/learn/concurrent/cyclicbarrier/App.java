package com.hurricane.learn.concurrent.cyclicbarrier;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * 循环等待，协调多个任务的进行
 * @author Administrator
 *
 */
public class App implements Runnable{
	static Random random = new Random();
	static CyclicBarrier barrier;
	static ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(10);
	static int cnt = 3;
	public static void main(String[] args) {
		barrier = new CyclicBarrier(10, ()->{
			cnt--;
			System.out.println("所有任务结束");
			if (cnt>0) {
				System.out.println("打开另外10个任务");
				newTenTask();
			}else {
				newFixedThreadPool.shutdown();
			}
		});
		newTenTask();
//		System.out.println("qqq");
	}
	
	public static void newTenTask() {
		for (int i = 0; i < 10; i++) {
			newFixedThreadPool.submit(new App());
		}
	}
	
	@Override
	public void run() {
		int t = random.nextInt(1000);
		System.out.println(Thread.currentThread().getName()+"---睡眠"+t+"ms");
		try {
			Thread.sleep(t);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"---退出");
		try {
			barrier.await();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
