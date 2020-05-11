package com.jellard.thread;

import java.util.LinkedHashMap;
import java.util.Map;

public class MyLru {
	
	private final int max_size;
	private final float factor = 0.75f;
	private LinkedHashMap<String, Object> map;
	
	public MyLru(int cacheSize) {
		max_size = cacheSize;
		int capacity = (int)Math.ceil(cacheSize/factor)+1;
		map =  new LinkedHashMap<String, Object>(capacity, factor, true) {
			
			private static final long serialVersionUID = 1L;

			@Override
			protected boolean removeEldestEntry(Map.Entry<String,Object> eldest) {
		        return size()>max_size;
		    }
		};
	}
	
	public static void main(String[] args) {
		MyLru myLru = new MyLru(8);
		for (int i = 0; i < 10; i++) {
			myLru.map.put(i+"", i);
			System.out.println(myLru.map);
		}
	}
	
	

}
