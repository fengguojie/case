package com.jellard.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest {
	
	private Lock lock = new ReentrantLock();
	private Condition condOdd = lock.newCondition();
	private Condition condEven = lock.newCondition();
	private boolean flag = true;
	private int count = 0;
	
	
	class PrintOdd implements Runnable{

		@Override
		public void run() {
			while (true) {
				if (count >= 100) {
					break;
				}
				try {
					lock.lock();
					if (!flag) {
						condOdd.await();
					}
					count++;
					System.out.println(Thread.currentThread().getName()+":"+count);
					flag = false;
					condEven.signal();
				} catch (Exception e) {
					e.printStackTrace();
				}finally {
					lock.unlock();
				}
			}
		}
	}
	
	class PrintEven implements Runnable{
		@Override
		public void run() {
			while (true) {
				if (count >= 100) {
					break;
				}
				try {
					lock.lock();
					if (flag) {
						condEven.await();
					}
					count++;
					System.out.println(Thread.currentThread().getName()+":"+count);
					flag = true;
					condOdd.signal();
				} catch (Exception e) {
					e.printStackTrace();
				}finally {
					lock.unlock();
				}
			}
		}
	}
	
	public static void main(String[] args) {
//		Thread thread = new Thread( new DemoRunable(), DemoRunable.class.getName());
//		thread.start();
//		System.out.println(thread.getName());
//		System.out.println(Thread.currentThread());
//		thread.interrupt();
//		System.out.println("是否停止1？="+thread.isInterrupted());
//        System.out.println("是否停止2？="+thread.isInterrupted());
//		System.out.println("main end");
		ThreadTest threadTest = new ThreadTest();
		Thread threada = new Thread(threadTest.new PrintOdd(), "线程A");
		Thread threadb = new Thread(threadTest.new PrintEven(), "线程B");
		
		System.out.println(Thread.currentThread());
		ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
		int count = threadGroup.activeCount();
		System.out.println(count);
		Thread[] threads = new Thread[count];
		threadGroup.enumerate(threads);
		for (Thread thread : threads) {
			
		}
		
		
	}

}
