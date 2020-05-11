package com.jellard.sort;

import java.util.Arrays;

public class FastSort {
	
	public static void main(String[] args) {
		int[] array = new int[] { 2, 1, 4, 3, 6, 5, 8, 7 };
		quickSort(array, 0, array.length-1);
		System.out.println(Arrays.toString(array));
	}
	
	
	private static void quickSort(int[] arr, int low, int high) {
		if (low < high) {
			int index = getIndex(arr, low, high);//找寻基准数据的正确索引
			//进行迭代对index之前和之后的数组进行相同的操作使整个数组变成有序
			quickSort(arr, 0, index - 1);
			quickSort(arr, index + 1, high);
		}
	}

	private static int getIndex(int[] arr, int low, int high) {
		int tmp = arr[low];// 基准数据
		while (low < high) {
			while (low < high && arr[high] >= tmp) {
				high--;  //当队尾的元素大于等于基准数据时,向前挪动high指针
			}
			arr[low] = arr[high];//如果队尾元素小于tmp了,需要将其赋值给low
			while (low < high && arr[low] <= tmp) {
				low++;//当队首元素小于等于tmp时,向前挪动low指针
			}
			arr[high] = arr[low];//当队首元素大于tmp时,需要将其赋值给high

		}
		arr[low] = tmp;//跳出循环时low和high相等,此时的low或high就是tmp的正确索引位置
		return low;// 返回tmp的正确位置
	}

}
