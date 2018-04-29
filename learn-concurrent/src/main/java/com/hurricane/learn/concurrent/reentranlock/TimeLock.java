package com.hurricane.learn.concurrent.reentranlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
/**
 * 尝试在指定的时间内获取锁，
 * 这是synchronized关键字没有的功能
 * @author Administrator
 *
 */
public class TimeLock implements Runnable{
	int i;
	static ReentrantLock lock1 = new ReentrantLock();
	static ReentrantLock lock2 = new ReentrantLock();
	
	public TimeLock(int ii) {
		i = ii;
	}
	
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new TimeLock(1),"t1");
		Thread t2 = new Thread(new TimeLock(0),"t2");
		t1.start();
		t2.start();
//		Thread.sleep(3000);
//		DeakLockChecker.check();
//		t1.interrupt();
//		t2.interrupt();
//		t1.join();
//		t2.join();
		System.out.println("程序结束");
	}

	@Override
	public void run() {
		if (i==1) {
			lock1.lock();
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				lock2.tryLock(3, TimeUnit.SECONDS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally{
				if (lock1.isHeldByCurrentThread()) {
					lock1.unlock();
					System.out.println(Thread.currentThread().getName()+"----unlock1");
				}
				if (lock2.isHeldByCurrentThread()) {
					lock2.unlock();
					System.out.println(Thread.currentThread().getName()+"----unlock2");
				}
			}
		}else {
			lock2.lock();
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				lock1.tryLock(3, TimeUnit.SECONDS);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				if (lock1.isHeldByCurrentThread()) {
					lock1.unlock();
					System.out.println(Thread.currentThread().getName()+"----unlock1");
				}
				if (lock2.isHeldByCurrentThread()) {
					lock2.unlock();
					System.out.println(Thread.currentThread().getName()+"----unlock2");
				}
			}
		}
	}
}
