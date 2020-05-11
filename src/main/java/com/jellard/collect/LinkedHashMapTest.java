package com.jellard.collect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LinkedHashMapTest {
	
	/**
	 * accessOrder the ordering mode - true for access-order, false for insertion-order
	 * @param args
	 */
	public static void main(String[] args) {
		Map<Integer, Integer> map = new LinkedHashMap<>(16, 0.75f, true);
		for (int i = 0; i < 6; i++) {
			map.put(i, i);
		}
		System.out.println(map.containsKey(2));
		System.out.println(map);
		map.put(3,6);//会修改遍历的顺序
		map.get(0);//会修改遍历的顺序
		System.out.println(map);
		
		//Arrays.asList(1,5)
		List<Integer> array = new ArrayList<>(Arrays.asList(1,5));
		System.out.println(array.contains(null));
		System.out.println(array.contains(1));
		System.out.println(array.contains(2));
		System.out.println(array.contains(new Integer(1)));
		
		
		
	}

}
