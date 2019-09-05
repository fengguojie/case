package com.jellard.zookeeper;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

public class ZkNodeUtil {
	
	
	public static void createNode() throws Exception {
		ZooKeeper conn = ZkConnectUtil.connect();
		String result = conn.create("/jellard", "hello node".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
		System.out.println(result);
	}

}
