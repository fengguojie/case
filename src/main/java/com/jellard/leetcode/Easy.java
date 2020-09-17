package com.jellard.leetcode;

public class Easy {
	
	/**
	 * 有序数组不同数的个数
	 * @param sortedArray
	 * @return
	 */
	public int count(int[] sortedArray) {
	    int slow=0;
	    for (int fast = 1; fast < sortedArray.length; fast++) {
			if (sortedArray[fast] != sortedArray[slow]) {
				slow++;
				sortedArray[slow] = sortedArray[fast];
			}
		}
		return slow+1;
	}
	
	/**
	 * 最大子序列
	 * @param array
	 * @return
	 */
	public int maxSum(int[] array) {
		int maxSum = array[0];
		int sum = array[0];
		for (int i = 1; i < array.length; i++) {
			if (sum+array[i] < array[i]) {
				sum=array[i];
			}else {
				sum+=array[i];
			}
			if (sum > maxSum) {
				maxSum = sum;
			}
		}
		return maxSum;
	}
	
	public static void main(String[] args) {
		Easy easy = new Easy();
		int[] sortedArray = {1,1,1,2,2,4,5,6,7};
		System.out.println("有序数组不同元素个数："+easy.count(sortedArray));
		int[] array = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println("最大子序列:"+easy.maxSum(array));
	}
	

}
