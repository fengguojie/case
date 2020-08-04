package com.jellard.design;

public class SingleInstance {

	//hungry pattern
//	private static SingleInstance instance = new SingleInstance();
//	private SingleInstance() {}
//	public static SingleInstance getInstance() {
//		return instance;
//	}
	
	//lazy pattern
//	private static SingleInstance instance = null;
//	private SingleInstance () {}
//	public static synchronized SingleInstance getInstance() {
//		if (instance != null) {
//			instance =  new SingleInstance();
//		}
//		return instance;
//	}
	
	//lazy double check pattern
//	private static volatile SingleInstance instance = null;//notice volatile key
//	private SingleInstance() {}
//	public static SingleInstance getInstance() {
//		if (instance == null) {
//			synchronized(SingleInstance.class){
//				if (instance == null) {
//					instance = new SingleInstance();
//				}
//			}
//		}
//		return instance;
//	}
	
	//lazy static inner class pattern
	private SingleInstance() {}
	private static class InstanceHolder{
		private static SingleInstance instance = new SingleInstance();
	}
	public static SingleInstance getInstance() {
		return InstanceHolder.instance;
	}

}
