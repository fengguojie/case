package com.jellard.thread;

public class DemoRunable implements Runnable{

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			System.out.println(Thread.currentThread().isInterrupted());
			System.out.println(i);
		}
	}

}
