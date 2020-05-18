package com.jellard.sort;

import java.util.LinkedList;

public class Treefy {
	
	public static void main(String[] args) {
		int[] array = {12,5,7,15,2,6,4,9,19};
		LinkedList<Tree> list = new LinkedList<>();
		for (int i = 0; i < array.length; i++) {
			list.add(new Tree(array[i]));
		}
		int lastParent = array.length/2-1;
		for (int i = 0; i < lastParent; i++) {
			list.get(i).left = list.get(2*i+1);
			list.get(i).right = list.get(2*i+2);
		}
		list.get(lastParent).left = list.get(lastParent*2+1);
		if ((array.length & 1) == 0) {
			list.get(lastParent).right = list.get(lastParent*2+2);
		}
		
		String str1 = "abfabcd";
		String str2 = "abc";
		int index = str1.indexOf(str2,4);
		System.out.println(index);
		System.out.println("end");
	}
	
	static class Tree{
		int data;
		Tree left;
		Tree right;
		
		public Tree(int data) {
			this.data = data;
		}
	}

}
