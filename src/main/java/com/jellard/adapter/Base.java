package com.jellard.adapter;

public class Base{
	sub sub = new sub();
	
	public sub getStr() {
		return sub;
	}
	
	public static void main(String[] args) {
//		Base base = new Base();
//		/**
//		 * get 对象的引用  然后基类完成赋值操作=》HttpServletResponseWrapper
//		 */
//		sub str2 = base.getStr();
//		str2.age = 1;
//		System.out.println(str2);
//		System.out.println(str2.age);
//		System.out.println(base.sub);
//		System.out.println(base.sub.age);
		int[] array = new int[] {1,3,5,7};
		int i = 1;
		int temp = array[i];
		for (int j = 0; j < 3; j++) {
			System.out.println(temp);
			i = j;
			System.out.println(temp);
		}
		
	}
}
class sub{
	public int age;
}
