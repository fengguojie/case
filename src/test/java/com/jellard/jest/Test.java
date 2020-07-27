package com.jellard.jest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
	
	public static void main(String[] args) {
		Integer [] cates = {1,2,3,4,5};
		List<Integer> arrayList = Arrays.asList(cates);
		//arrayList.add(0, 6);
		System.out.println(arrayList);
    	List<Integer> list = new ArrayList<>(Arrays.asList(cates));
    	list.add(0,6);
    	System.out.println(list);
	}

}
