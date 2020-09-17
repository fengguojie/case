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
	
	public static void main(String[] args) {
		Easy easy = new Easy();
		int[] sortedArray = {0,1,1,2,2,4,5,6,7};
		int count = easy.count(sortedArray);
		System.out.println(""+count);
	}
	

}
