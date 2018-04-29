package com.hurricane.learn.concurrent.reentranlock;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;


/**
 * 用于死锁检查的守护线程
 * @author Administrator
 *
 */
public class DeakLockChecker {
	static ThreadMXBean mxBean = ManagementFactory.getThreadMXBean();
	static Runnable checkerRunnable = new Runnable() {
		@Override
		public void run() {
			while (true) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				long[] deadLockThreadIds = mxBean.findDeadlockedThreads();
				if (deadLockThreadIds!=null&&deadLockThreadIds.length>0) {
					System.out.println("检查到死锁，数量为"+deadLockThreadIds.length);
					Set<Entry<Thread, StackTraceElement[]>> it = Thread.getAllStackTraces().entrySet();
					for (Entry<Thread, StackTraceElement[]> entry : it) {
						Thread t = entry.getKey();
						for (int i = 0; i < deadLockThreadIds.length; i++) {
							if (t.getId()==deadLockThreadIds[i]) {
								System.out.println("发送中断："+t.getId());
								t.interrupt();
							}
						}
						
					}
				}
			}
		}
	};
	
	public static void check() {
		Thread checker = new Thread(checkerRunnable);
		checker.setDaemon(true);
		checker.start();
	}

}
