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
//	static ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(10);
	static int cnt = 3;
	public static void main(String[] args) throws InterruptedException {
		barrier = new CyclicBarrier(10, ()->{
			cnt--;
			System.out.println("所有任务结束");
			if (cnt>0) {
				System.out.println("打开另外10个任务");
				try {
					newTenTask();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else {
//				newFixedThreadPool.shutdown();
			}
		});
		newTenTask();
//		System.out.println("qqq");
	}
	
	public static void newTenTask() throws InterruptedException {
//		for (int i = 0; i < 10; i++) {
//			newFixedThreadPool.submit(new App());
//		}
		for (int i = 0; i < 10; i++) {
			Thread thread = new Thread(new App());
			thread.start();
			if (i==5) {
				Thread.sleep(100);
				if (thread.isAlive()) {
					System.out.println(thread.getName()+"---alive");
					thread.interrupt();
				}
//				try {
//					Thread.sleep(100);
//					if (thread.isAlive()) {
//						System.out.println(thread.getName()+"---alive");
//						thread.interrupt();
//					}
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
			}
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
