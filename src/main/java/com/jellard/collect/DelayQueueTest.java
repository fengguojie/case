package com.jellard.collect;

import java.util.Date;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DelayQueueTest {
	private static DelayQueue<DelayTask> delayQueue = new DelayQueue<>();
	
	public static void main(String[] args) {
		long current = System.currentTimeMillis();
		delayQueue.offer(new DelayTask("1", "11", 5000));
		delayQueue.offer(new DelayTask("3", "11", 8000));
		delayQueue.offer(new DelayTask("2", "11", 6000));
		
		System.out.println(new Date());
		Executors.newSingleThreadExecutor().execute(new Runnable() {
			
			@Override
			public void run() {
				while (true) {
					try {
						DelayTask task = delayQueue.take();
						System.out.println(task.getTaskId()+":"+new Date());
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}

}

class DelayTask implements Delayed{
	
	private String taskId;
    private String businessId;
    private long   executeTime;
    
    public DelayTask() {}
    
    public DelayTask(String taskId,String businessId,long executeTime) {
		this.taskId = taskId;
		this.businessId = businessId;
		this.executeTime = executeTime+System.currentTimeMillis();
	}
    
	@Override
	public int compareTo(Delayed o) {
		DelayTask task = (DelayTask)o;
		long result = executeTime- task.executeTime;
		if (result < 0) {
			return -1;
		}
		if (result > 0) {
			return 1;
		}
		return 0;
	}

	@Override
	public long getDelay(TimeUnit unit) {
		long diff = executeTime-System.currentTimeMillis();
		return unit.convert(diff, TimeUnit.NANOSECONDS);
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getBusinessId() {
		return businessId;
	}

	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}

	public long getExecuteTime() {
		return executeTime;
	}

	public void setExecuteTime(long executeTime) {
		this.executeTime = executeTime;
	}
	
	
}
