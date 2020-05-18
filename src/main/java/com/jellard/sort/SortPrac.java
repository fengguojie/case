package com.jellard.sort;

import java.util.Arrays;

public class SortPrac {
	
	public static void main(String[] args) {
		int[] array = {12,5,7,15,2,6,4,9,19};
		popSort(array);
		System.out.println("简单比较（冒泡排序）："+Arrays.toString(array));
		FastSort(array,0,array.length-1);
		System.out.println("比较排序（快速排序）："+Arrays.toString(array));
		heapSort(array);
		System.out.println("选择排序（堆排序）："+Arrays.toString(array));
		
		int[] sortArray = {1,5,7,15,20,30,45,99,199};
		int index =  binarySearch(sortArray,0,sortArray.length-1);
		System.out.println("所在位置："+index);
	}
    private static int data = 3;
	private static int binarySearch(int[] sortArray, int start, int end) {
		if (start > end) {
			return -1;
		}
		int middle = (end+start)/2;
		if (sortArray[middle] == data) {
			return middle;
		}else if (sortArray[middle] > data) {
			return binarySearch(sortArray, start, middle-1);
		}else {
			return binarySearch(sortArray, middle+1, end);
		}
	}

	private static void heapSort(int[] array) {
		for (int i = array.length/2-1; i >= 0; i--) {
			adjustHeap(array,i,array.length);
		}
		
		for (int j = array.length-1; j >0; j--) {
			int temp = array[j];
			array[j] = array[0];
			array[0] = temp;
			adjustHeap(array, 0, j);
		}
		
	}

	private static void adjustHeap(int[] array, int i, int length) {
		int temp = array[i];
		for(int k=2*i+1;k<length;k=2*k+1) {
			if (k+1 < length && array[k] < array[k+1]) {
				k++;
			}
			if (temp < array[k]) {
				array[i] = array[k];
				i = k;//新增
			}else {
				break;
			}
		}
		array[i] = temp;
	}

	private static void FastSort(int[] array, int low, int high) {
		if (low < high) {
			int index = getIndex(array,low,high);
			FastSort(array, 0, index-1);
			FastSort(array, index+1, high);
		}
	}

	private static int  getIndex(int[] array, int low, int high) {
		int temp = array[low];
		while(low < high) {
			while (low < high && temp <= array[high]) {
				high--;
			}
			array[low] = array[high];
			while(low < high && temp >= array[low] ) {
				low--;
			}
			array[high] = array[low];
		}
		array[low] = temp;
		return low;
	}

	private static void popSort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length-i-1; j++) {
				if (array[j] > array[j+1]) {
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
	}

}
