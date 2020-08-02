package com.jellard.algorithm;

import java.util.Arrays;

public class ArrayAlgorithm {
	
	public void leftMove(int[] array,int k) {
		reverse(array, 0, k-1);
		reverse(array, k, array.length-1);
		reverse(array, 0, array.length-1);
	}
	
	public void rightMove(int[] array,int k) {
		reverse(array, 0, array.length-k-1);
		reverse(array, array.length-k, array.length-1);
		reverse(array, 0, array.length-1);
	}
	
	private void reverse(int[] array,int i,int j) {
		while(i<j) {
			int temp = array[i];
			array[i] = array[j];
			array[j] = temp;
			i++;
			j--;
		}
	}
	
	public static void main(String[] args) {
		ArrayAlgorithm algorithm = new ArrayAlgorithm();
		int[] array = {1,2,3,4,5,6,7};
		//algorithm.leftMove(array, 4);
		algorithm.rightMove(array, 2);
		System.out.println(Arrays.toString(array));
	}

}
