package com.jellard.algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class SortAlgorithm {
	
	public static void main(String[] args) {
		SortAlgorithm algorithm =  new SortAlgorithm();
		System.out.println("------sorts------");
		System.out.println("1:maopo");
		System.out.println("2:fast");
		System.out.println("3:select");
		System.out.println("4:heap");
		System.out.println("5:insert");
		System.out.println("6:shell");
		System.out.println("7:merge");
		System.out.println("0:exit");
		Scanner input = new Scanner(System.in);
		while(true) {
			int[] array = {12,5,7,15,2,6,4,9,19};
			System.out.print("please input a number:");
			int num = input.nextInt();
			if (num == 0) {
				break;
			}
			switch (num) {
			case 1:
				algorithm.maopoSort(array);
				System.out.println("maopo:"+Arrays.toString(array));
				break;
			case 2:
				algorithm.fastSort(array,0,array.length-1);
				System.out.println("fast:"+Arrays.toString(array));
				break;
			case 3:
				algorithm.select(array);
				System.out.println("select:"+Arrays.toString(array));
				break;
			case 4:
				algorithm.heapSort(array);
				System.out.println("heap:"+Arrays.toString(array));
				break;
			case 5:
				algorithm.insert(array);
				System.out.println("insert:"+Arrays.toString(array));
				break;
			case 6:
				algorithm.shell(array);
				System.out.println("shell:"+Arrays.toString(array));
				break;
			case 7:
				int[] result = new int[array.length]; 
				algorithm.merge(array,result,0,array.length-1);
				System.out.println("merge:"+Arrays.toString(result));
				break;
			default:
				break;
			}
		}
		input.close();
		System.out.println("game over");
	}
	
	//swap sort
	public void maopoSort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length-i-1; j++) {
				if (array[j] > array[j+1]) {
					int temp = array[j+1];
					array[j+1] = array[j];
					array[j] = temp;
				}
			}
		}
	}
	public void fastSort(int[] array,int low,int high) {
		if (low >= high) {
			return;
		}
		int index = getIndex(array, low, high);
		fastSort(array, low, index-1);
		fastSort(array, index+1, high);
	}
	private int getIndex(int[] array,int low,int high) {
		int temp = array[low];
		while (low < high) {
			while(low < high && temp <= array[high]) {
				high--;
			}
			array[low] = array[high];
			while(low < high && temp >= array[low]) {
				low++;
			}
			array[high] = array[low];
		}
		array[low] = temp;
		return low;
	}
	
    //select sort
	public void select(int[] array) {
		for (int i = 0; i < array.length; i++) {
			int k = 0;
			for (int j = 0; j < array.length-i; j++) {
				if (array[k] < array[j]) {
					k = j;
				}
			}
			int temp = array[array.length-i-1];
			array[array.length-i-1]  = array[k];
			array[k] = temp;
		}
	}
	public void heapSort(int[] array) {
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
	private void adjustHeap(int[] array, int i, int length) {
		int temp = array[i];
		for(int k=2*i+1;k<length;k=2*k+1) {
			if (k+1 < length && array[k] < array[k+1]) {
				k++;
			}
			if (temp < array[k]) {
				array[i] = array[k];
				i = k;//for jump loop swap value
			}else {
				break;
			}
		}
		array[i] = temp;
	}
	
	//insert
	public void insert(int[] array) {
		for (int i = 0; i < array.length; i++) {
			int temp = array[i];
			int j = i-1;//sorted array length
			while(j>=0 && temp<array[j]) {
				array[j+1] = array[j];
				j--;
			}
			array[j+1] = temp;
		}
	}
	public void shell(int[] array) {
		int len = array.length;
		while(len > 0) {
			len = len/2;
			for (int group = 0; group < len; group++) {
				for (int i = group+len; i < array.length; i=i+len) {
					int temp = array[i];
					int j = i-len;
					while(j>=0 && temp < array[j]) {
						array[j+len] = array[j];
						j = j-len;
					}
					array[j+len] = temp;
				}
			}
		}
	}
	
	//merge
	public void merge(int[] arr, int[] result, int start, int end) {
	    if (start >= end)
	        return;
	    int len = end - start, mid = len/2 + start;
	    int start1 = start, end1 = mid;
	    int start2 = mid + 1, end2 = end;
	    merge(arr, result, start1, end1);
	    merge(arr, result, start2, end2);
	    int k = start;
	    while (start1 <= end1 && start2 <= end2)
	        result[k++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
	    while (start1 <= end1)
	        result[k++] = arr[start1++];
	    while (start2 <= end2)
	        result[k++] = arr[start2++];
	    for (k = start; k <= end; k++)
	        arr[k] = result[k];
	}

}
