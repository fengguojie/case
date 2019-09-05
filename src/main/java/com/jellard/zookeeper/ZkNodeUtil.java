package com.jellard.zookeeper;

import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

public class ZkNodeUtil {
	
	private static ZooKeeper conn;
	
	static {
		conn = ZkConnectUtil.connect();
	}
	
	public static boolean exists(String path) throws Exception {
		Stat stat = conn.exists(path, false);
		if(stat != null) {
			return true;
		}
		return false;
	}
	
	public static void createNode(String path,String data) throws Exception {
		if (exists(path)) {
			System.out.println("znode is exists!");
			return;
		}
		String result = conn.create(path, data.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
		System.out.println(result);
	}
	
	public static String getDate(String path) throws Exception{
		if (!exists(path)) {
			System.out.println("znode not exists!");
			return null;
		}
		byte[] data = conn.getData(path, false, null);
		String content = new String(data);
		return content;
	}
	
	public static int setDate(String path,String content) throws Exception{
		if (!exists(path)) {
			System.out.println("znode not exists!");
			return -1;
		}
		Stat stat = conn.setData(path, content.getBytes(), conn.exists(path, false).getVersion());
		return stat.getVersion();
	}
	
	public static void getChildren(String path) throws Exception{
		if (!exists(path)) {
			System.out.println("znode not exists!");
			return;
		}
		final CountDownLatch countDownLatch = new CountDownLatch(1);
		List<String> children = conn.getChildren(path, new Watcher() {
			public void process(WatchedEvent event) {
				if (event.getType() == EventType.NodeChildrenChanged) {
					String childPath = event.getPath();
					System.out.println(childPath+":childnode changed");
				}
				if (event.getType() == EventType.NodeCreated) {
					String childPath = event.getPath();
					System.out.println(childPath+"node create");
				}
				if (event.getType() == EventType.NodeDeleted) {
					String childPath = event.getPath();
					System.out.println(childPath+"node delete");
				}
				countDownLatch.countDown();
			}
		});
		children.forEach(child ->{
			System.out.println("child node:"+child);
		});
	    countDownLatch.await();
	    System.out.println("over");
		return;
	}
	
	public static void delete(String path) throws Exception{
		if (!exists(path)) {
			System.out.println("znode not exists!");
			return;
		}
		conn.delete(path, conn.exists(path, false).getVersion());
	}
	
	
	

}
