package com.jellard.algorithm;

public class StringAlgorithm {
	
	
	public boolean match(String str1,String str2) {
		char[] array1 = str1.toCharArray();
		char[] array2 = str2.toCharArray();
		for (int i = 0; i < array1.length-array2.length+1; i++) {
			int k = 0;
			int j = i;
			while(k < array2.length) {
				if (array1[j] == array2[k]) {
					k++;
					j++;
				}else {
					break;
				}
			}
			if (k == array2.length) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		StringAlgorithm algorithm =  new StringAlgorithm();
		System.out.println(algorithm.match("abcdefg", "bbcdefg"));
	}

}
