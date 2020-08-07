package com.jellard.algorithm;

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
	
	public int maxSubarray(int[] array) {
	    int max = -100000;
        for (int i = 0; i < array.length; i++) {
			for (int j = i; j < array.length; j++) {
				int sum = 0;
				int k = i;
				while(k <= j) {
					sum = sum + array[k];
					k++;
				}
				if (max < sum) {
					max = sum;
				}
			}
		}
	    return max; 
	}
	
	private int maxSubarray2(int[] array){
	    int max = -100000;
	    for (int i = 0; i < array.length; i++){
	        int sum = 0;
	        for (int j = i; j < array.length; j++){
	            sum += array[j];
	            if (sum > max){
	                max = sum;
	            }
	        }
	    }
	    return max;
	}
	
	private int maxSubarray3(int[] array){
	    int max = -100000;
	    int sum = 0;
	    for (int i = 0; i < array.length; i++){
	        sum += array[i];
            if (sum < array[i]){
            	sum = array[i];
            }
            if (sum > max) {
            	max = sum;
			}
	    }
	    return max;
	}
	
	
	public static void main(String[] args) {
		ArrayAlgorithm algorithm = new ArrayAlgorithm();
		int[] array = {13,-5,-3,-4,5,8,-7};
		//algorithm.leftMove(array, 4);
		//algorithm.rightMove(array, 2);
		//System.out.println(Arrays.toString(array));
		
		int maxSubarray = algorithm.maxSubarray(array);
		System.out.println(maxSubarray);
		int maxSubarray2 = algorithm.maxSubarray3(array);
		System.out.println(maxSubarray2);
	}

}
