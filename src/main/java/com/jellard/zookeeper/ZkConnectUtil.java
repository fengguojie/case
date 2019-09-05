package com.jellard.zookeeper;

import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooKeeper;

public class ZkConnectUtil {
	
	private static String defaultHost = "localhost";
	private static CountDownLatch countDownLatch = new CountDownLatch(1);
	
	private static ZooKeeper zk;
	
	public static ZooKeeper connect() throws Exception {
		return connect(defaultHost);
	}
	
	public static ZooKeeper connect(String host) throws Exception {
		zk = new ZooKeeper(host, 5000, new Watcher() {
			public void process(WatchedEvent event) {
				if (event.getState() == KeeperState.SyncConnected) {
					countDownLatch.countDown();
				}
			}
		});
		countDownLatch.await();
		return zk;
	}
	
	public static void close() throws Exception {
		if (zk == null) {
			return;
		}
		zk.close();
	}

}
