package com.jellard.algorithm;

public class BigNumCalculate {
	
	public String addBetter(String str1,String str2) {
		String str = "";
		int length1 = str1.length();
		int length2 = str2.length();
		int temp = 0;
		int index = 1;
		while(index <= length1 || index <= length2) {
			int num1 = length1<index?0:Integer.parseInt(String.valueOf(str1.charAt(length1-index)));
			int num2 = length2<index?0:Integer.parseInt(String.valueOf(str2.charAt(length2-index)));
			int num = num1+num2+temp;
			if(num >= 10) {
				temp = 1;
				str=num%10+str;
			}else {
				temp = 0;
				str = num+str;
			}
			index++;
		}
		if (temp != 0) {
			str = 1+str;
		}
		return str;
	}
	
	public String add(String str1,String str2) {
		String str = "";
		int temp = 0;
		while(!"".equals(str1) || !"".equals(str2)) {
			int length1 = str1.length();
			int length2 = str2.length();
			int num1 = length1==0?0:Integer.parseInt(str1.substring(length1-1));
			int num2 = length2==0?0:Integer.parseInt(str2.substring(length2-1));
			int num = num1+num2+temp;
			if(num >= 10) {
				temp = 1;
				str = num%10+str;
			}else {
				temp = 0;
				str = num+str;
			}
			str1 = length1==0?"":str1.substring(0,length1-1);
			str2 = length2==0?"":str2.substring(0,length2-1);
		}
		if (temp != 0) {
			str = 1+str;
		}
		return str;
	}
	
	public static void main(String[] args) {
		BigNumCalculate calculate =  new BigNumCalculate();
		String str = calculate.add("999999999999999", "123");
		String str2 = calculate.addBetter("999999999999999", "123");
		System.out.println(str);
		System.out.println(str2);
		long num = 999999999999999L;
		long num2 = 123L;
		System.out.println(num+num2);
	}

}
