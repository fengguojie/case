package com.jellard.sort;

public class Test {

	    public static int getABA(int number){
		        int small = 0;
		        int big = number;
		        int i = number,j = number;
		        while (i>0){
		            i =i-1;
		            if(isABA(i)){
		                small = i;
		                break;
		            }
		        }
		        while (j<100000000){
		            j =j+ 1;
		            if(isABA(j)){
		                big = j;
		                break;
		            }
		        }
		        if(small==0 && small==number ){
		            return big;
		        }
	            if(big==0){
	                return small;
	            }
	            int betSmall = number - small;
	            int betBig = big - number;
	            if(betSmall == betBig){
	                return small;
	            }
	            return betSmall<betBig?small:big;
	        }
	        
	        public static Boolean isABA(int number){
	            String strNum = String.valueOf(number);
	            String left;
	            String right;
	            if(strNum.length()%2==1){
	                left = strNum.substring(0,strNum.length()/2);
	                right = strNum.substring(strNum.length()/2+1);
	            }else {
	                left = strNum.substring(0,strNum.length()/2);
	                right = strNum.substring(strNum.length()/2);
	            }
	            if(left.equals(revert(right))){
	                return true;
	            }
	            return false;
	        }
	        public static String revert(String str){
	            StringBuffer sb = new StringBuffer(str);
	            String str2 = sb.reverse().toString();
	            return str2;
	        }
	        
	        public static void main(String[] args) {
				int aba = getABA(210);
				System.out.println(aba);
			}

}
