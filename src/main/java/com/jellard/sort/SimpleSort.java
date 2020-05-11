package com.jellard.sort;

public class SimpleSort {
	
	//简单比较排序
	public int[] bubbleSort(int[] unsorted){
		int length = unsorted.length;
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length-i-1; j++) {
				if (unsorted[j] > unsorted[j+1]) {
					int temp = unsorted[j];
					unsorted[j] = unsorted[j+1];
					unsorted[j+1] = temp;
				}
			}
		}
		return  unsorted;
	}
	
	//简单选择排序
	public int[] selection(int[] unsorted){
		int length = unsorted.length;
		int temp;
		int k;
		for (int i = 0; i < length; i++) {
			k = i;
			for (int j = i+1; j < length; j++) {
				if (unsorted[k] > unsorted[j]) {
					k = j;
				}
			}
			temp = unsorted[i];
			unsorted[i] = unsorted[k];
			unsorted[k] = temp;
		}
		return unsorted;
	}
	public int[] insertionSort(int[] unsorted){
		int len = unsorted.length;
		int preIndex,current;
		for (int i = 1; i < len; i++) {
			preIndex = i-1;
			current = unsorted[i];
			while (i>=0 && unsorted[preIndex] > current) {
				unsorted[preIndex+1] = unsorted[preIndex];
				preIndex--;
			}
			unsorted[preIndex+1] = current; 
		}
		return  unsorted;
	}
	

}
