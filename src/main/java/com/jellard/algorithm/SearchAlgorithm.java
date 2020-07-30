package com.jellard.algorithm;

import java.util.Scanner;

public class SearchAlgorithm {
	
	
	public int binarySearch(int[] array,int key,int start,int end) {
		if (key<array[start] || key>array[end] || start > end) {
			return -1;
		}
		int mid = (start+end)/2;
		if (array[mid] == key) {
			return mid;
		}else if (array[mid] < key) {
			return binarySearch(array, key, mid+1, end);
		}else {
			return binarySearch(array, key, start, mid-1);
		}
	}
	
	public static void main(String[] args) {
		SearchAlgorithm algorithm =  new SearchAlgorithm();
		int[] sortArray = {1,5,7,15,20,30,45,99,199,201};
		Scanner input = new Scanner(System.in);
		while (true) {
			System.out.println("please input a num to search: ");
			int key = input.nextInt();
			if (key == -1) {
				System.out.println("game over");
				break;
			}
			int index = algorithm.binarySearch(sortArray, key, 0, sortArray.length-1);
			System.out.println("index of key is: "+index);
		}
		input.close();
	}

}
