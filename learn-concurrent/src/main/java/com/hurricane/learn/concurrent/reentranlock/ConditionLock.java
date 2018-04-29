package com.hurricane.learn.concurrent.reentranlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
/**
 * 由重入锁构建condition，condition的await、signal方法，
 * 对应于object的wait、notify方法
 * @author Administrator
 *
 */
public class ConditionLock {
	static ReentrantLock lock = new ReentrantLock();
	//以下是两种不同的condition
	static Condition condition = lock.newCondition();
	static Condition condition2 = lock.newCondition();

	public static void main(String[] args) {
		Runnable runnable1 = ()->{
			lock.lock();
			try {
				System.out.println(Thread.currentThread().getName()+"---开始等待");
				condition.await();
				System.out.println(Thread.currentThread().getName()+"---等待结束");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally {
			  if (lock.isHeldByCurrentThread()) {
				lock.unlock();
				System.out.println(Thread.currentThread().getName()+"---释放锁");
			  }
			}
		};
		Runnable runnable2 = ()->{
			try {
				lock.tryLock(3,TimeUnit.SECONDS);
				System.out.println(Thread.currentThread().getName()+"---获取到锁");
				Thread.sleep(1000);
				condition.signal();
				System.out.println(Thread.currentThread().getName()+"通知condition");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally {
			  if (lock.isHeldByCurrentThread()) {
				  lock.unlock();
				  System.out.println(Thread.currentThread().getName()+"---释放锁");
			}
			}
		};
		Thread t1 = new Thread(runnable1,"t1");
		Thread t2 = new Thread(runnable2,"t2");
		t1.start();
		t2.start();
	}
	
	
}
