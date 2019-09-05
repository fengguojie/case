package com.jellard.zookeeper;

import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooKeeper;

public class ZkConnectUtil {
	
	private static String defaultHost = "localhost:2181";
	private static CountDownLatch countDownLatch = new CountDownLatch(1);
	
	private static ZooKeeper zk;
	
	public static ZooKeeper connect(){
		try {
			return connect(defaultHost);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static ZooKeeper connect(String host) {
		try {
			zk = new ZooKeeper(host, 5000, new Watcher() {
				public void process(WatchedEvent event) {
					if (event.getState() == KeeperState.SyncConnected) {
						countDownLatch.countDown();
					}
				}
			});
			countDownLatch.await();
			return zk;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void close() throws Exception {
		if (zk == null) {
			return;
		}
		zk.close();
	}

}
