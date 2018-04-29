package com.hurricane.learn.concurrent.readwritelock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class App {
	static CountDownLatch latch = new CountDownLatch(20);
	static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	static Runnable write = ()->{
		WriteLock writelk = readWriteLock.writeLock();
		writelk.lock();
		System.out.println(Thread.currentThread().getName()+"进入write");
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println(Thread.currentThread().getName()+"退出write");
		  writelk.unlock();
		  latch.countDown();
		}
	};
	static Runnable read = ()->{
		ReadLock readlk = readWriteLock.readLock();
		readlk.lock();
		System.out.println(Thread.currentThread().getName()+"进入read");
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println(Thread.currentThread().getName()+"退出read");
			readlk.unlock();
			latch.countDown();
		}
	};
	public static void main(String[] args) {
//		未获得锁的情况下，释放锁会抛异常，但是这种情况发生在线程池的线程中，是不会抛出异常的，但是之后的代码不执行
//		ReadLock lock = readWriteLock.readLock();
//		lock.unlock();
//		System.out.println("退出unlock");
		
		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(20);
		/**
		 * 读写互斥
		 */
//		for (int i = 0; i < 10; i++) {
//			newFixedThreadPool.submit(write);
//			newFixedThreadPool.submit(read);
//		}
		/**
		 * 写写互斥
		 */
//		for (int i = 0; i < 20; i++) {
//			newFixedThreadPool.submit(write);
//		}
		/**
		 * 读读不互斥
		 */
		for (int i = 0; i < 20; i++) {
			newFixedThreadPool.submit(read);
		}
		try {
			latch.await();
			System.out.println("all task end");
			newFixedThreadPool.shutdown();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
