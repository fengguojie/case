package com.jellard.sort;

import java.util.Arrays;

public class FastSort {
	
	public static void main(String[] args) {
		int[] array = new int[] { 2, 1, 4, 3, 6, 5, 8, 7 };
		fastSort(array, 0, array.length-1);
		System.out.println(Arrays.toString(array));
	}

	private static void fastSort(int[] array, int low, int high) {
		if (low < high) {
			int index = getIndex(array,low,high);
			fastSort(array, 0, index-1);
			fastSort(array, index+1, high);
		}
	}

	private static int getIndex(int[] array, int low, int high) {
		int temp = array[low];
		while(low < high) {
			while(low < high && array[high] >= temp) {
				high--;
			}
			array[low] = array[high];
			while(low < high && array[low] <= temp) {
				low++;
			}
			array[high] = array[low];
		}
		array[low] = temp;
		return low;
	}
	
	

}
