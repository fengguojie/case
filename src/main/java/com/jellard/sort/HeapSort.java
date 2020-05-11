package com.jellard.sort;

import java.util.Arrays;

public class HeapSort {
	
	public static void main(String[] args) {
		int[] array = new int[] { 2, 1, 4, 3, 6, 5, 8, 7 };
		sort(array);
		System.out.println(Arrays.toString(array));
	}
	
	public static void sort(int[] array) {
		int index = array.length/2-1;//知道最后一个非叶子节点
		for (int i = index; i >= 0; i--) {
			adjustHeap(array, i, array.length);
		}
 
		for (int j = array.length - 1; j > 0; j--) {
			swap(array, 0, j);//最大的元素放到数组尾部
			adjustHeap(array, 0, j);//接下来 自上而下 自左向右 调整堆
		}
	}
 
	public static void adjustHeap(int[] array, int i, int length) {
		int temp = array[i];
		for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {
			if (k + 1 < length && array[k] < array[k + 1]) {
				k++;//找到子节点最大的一个
			}
			// 如果发现子节点更大，则进行值的交换
			if (array[k] > temp) {
				swap(array, i, k);
				i = k;//子树是否收到影响
			} else {
				break;//如果不用交换，那么，就直接终止循环了
			}
		}
	}
 
	public static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}


}
