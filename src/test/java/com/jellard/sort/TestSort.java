package com.jellard.sort;

import java.util.Random;

public class TestSort {
	
	public static void main(String[] args) {
		int[] data = new int[20];
		Random random = new Random();
		for (int i = 0; i < data.length; i++) {
			data[i] = random.nextInt(100);
		}
		SimpleSort simpleSort = new SimpleSort();
		long start = System.currentTimeMillis();
		int[] sortedData1 = simpleSort.bubbleSort(data);
		int[] sortedData2 = simpleSort.insertionSort(data);
		int[] sortedData3 = simpleSort.selection(data);
		long end = System.currentTimeMillis();
		System.out.println("consume time :"+(end-start));
		
		
	}

}
