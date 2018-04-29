package com.hurricane.learn.concurrent.reentranlock;

import java.util.concurrent.locks.ReentrantLock;
/**
 * synchronized锁是无法被中断的
 * @author Administrator
 *
 */
public class App2 implements Runnable{
	int i;
	static Object lock1 = new Object();
	static Object lock2 = new Object();
	
	public App2(int ii) {
		i = ii;
	}
	
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new App2(1));
		Thread t2 = new Thread(new App2(0));
		t1.start();
		t2.start();
//		Thread.sleep(3000);
		DeakLockChecker.check();
//		t1.interrupt();
//		t2.interrupt();
//		t1.join();
//		t2.join();
		System.out.println("程序结束");
	}

	@Override
	public void run() {
		if (i==1) {
			synchronized (lock1) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (lock2) {
					
				}
			}
		}else {
			synchronized (lock2) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (lock1) {
					
				}
			}
		}
	}
}
