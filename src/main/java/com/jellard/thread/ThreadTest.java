package com.jellard.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest {
	
	private Lock lock = new ReentrantLock();
	private Condition condOdd = lock.newCondition();
	private Condition condEven = lock.newCondition();
	private boolean oddFlag = true;
	private boolean evenFlag = false;
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
					if (evenFlag) {
						condOdd.await();
					}
					count++;
					System.out.println(Thread.currentThread().getName()+":"+count);
					oddFlag = false;
					evenFlag = true;
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
					if (oddFlag) {
						condEven.await();
					}
					count++;
					System.out.println(Thread.currentThread().getName()+":"+count);
					oddFlag = true;
					evenFlag = false;
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
		new Thread(threadTest.new PrintOdd(), "线程A").start();
		new Thread(threadTest.new PrintEven(), "线程B").start();
		
	}

}
