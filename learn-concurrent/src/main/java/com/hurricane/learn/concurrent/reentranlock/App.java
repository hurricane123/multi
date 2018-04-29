package com.hurricane.learn.concurrent.reentranlock;

import java.util.concurrent.locks.ReentrantLock;
/**
 * 重入锁通过lockInterruptibly获取，可被中断
 * 通过lock方法获取和synchronized关键字一样无法被中断
 * @author Administrator
 *
 */
public class App implements Runnable{
	int i;
	static ReentrantLock lock1 = new ReentrantLock();
	static ReentrantLock lock2 = new ReentrantLock();
	
	public App(int ii) {
		i = ii;
	}
	
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new App(1));
		Thread t2 = new Thread(new App(0));
		t1.start();
		t2.start();
		Thread.sleep(3000);
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
			try {
				lock1.lockInterruptibly();
				Thread.sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				lock2.lockInterruptibly();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}else {
			try {
				lock2.lockInterruptibly();
				Thread.sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				lock1.lockInterruptibly();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
