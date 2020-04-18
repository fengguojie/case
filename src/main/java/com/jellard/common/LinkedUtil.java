package com.jellard.common;

public class LinkedUtil {
	
	static class Node{
		Node next;
		String element;
		
		public Node() {}
		
		public Node(String element) {
			this.element = element;
		}
	}
	
	Node head;//头结点
	
	public void add(Node node) {
		if (head == null) {
			head = new Node();
			head.next = node;
		}else {
			Node curHeadNext = head.next;
			head.next = node;
			node.next = curHeadNext;
		}
	}
	
	public void getAll() {
		if (head == null) {
			System.out.println("空链表");
		}else {
			StringBuffer sb =  new StringBuffer();
			Node node = head.next;
			while(node != null) {
				if (node.next == null) {
					sb.append(node.element);
					break;
				}
				sb.append(node.element).append("->");
				node = node.next; 
			}
			System.out.println(sb.toString());
		}
	}
	
	public static void main(String[] args) {
		LinkedUtil linkedUtil = new LinkedUtil();
		for (int i = 0; i < 10; i++) {
			linkedUtil.add(new Node(String.valueOf(i)));
		}
		linkedUtil.getAll();
	}

}
