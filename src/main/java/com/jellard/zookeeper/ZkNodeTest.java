package com.jellard.zookeeper;

import org.apache.zookeeper.ZKUtil;

public class ZkNodeTest {
	
	public static void main(String[] args) {
		try {
			String path = "/jellard/child01";
			String pathData = "hello child01";
//			ZkNodeUtil.createNode(path,pathData);
//			System.out.println(ZkNodeUtil.getDate(path));
//			int version = ZkNodeUtil.setDate(path, "update child01");
//			System.out.println("current version:"+version);
//			ZkNodeUtil.getChildren("/jellard");
			ZkNodeUtil.delete("/jellard/child04");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
