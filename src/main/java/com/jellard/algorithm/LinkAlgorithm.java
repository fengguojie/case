package com.jellard.algorithm;

import java.util.Arrays;
import java.util.Random;

public class LinkAlgorithm {
	
	static class LinkNode{
		int data;
		LinkNode next;
	}
	
	LinkNode head = new LinkNode();
	LinkNode tail;
	
	public LinkNode headAdd(int data) {
		LinkNode node =  new LinkNode();
		node.data = data;
		LinkNode temp = head.next;
		head.next = node;
		node.next = temp;
		return head;
	}
	
	public LinkNode tailAdd(int data) {
		LinkNode node =  new LinkNode();
		node.data = data;
		if (head.next == null) {
			head.next = node;
			tail = node;
		}else {
			tail.next = node;
			tail = tail.next;
		}
		return head;
	}
	
	public LinkNode reverse() {
		if (head == null) {
			return null;
		}
		LinkNode curNode = head.next;
		LinkNode next = null;
		while(curNode != null) {
			LinkNode temp = curNode.next;
			head.next = curNode;
			curNode.next = next;
			next = curNode;
			curNode = temp;
		}
		return head;
	}
	
	public boolean circular() {
		if (head == null) {
			return false;
		}
		LinkNode slow = head;
		LinkNode fast = head;
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			slow =  slow.next;
			if (fast == slow) {
				return true;
			}
		}
		return false;
	}
	
	public LinkNode merge(LinkNode link1,LinkNode link2) {
		if (link1 == null || link2 == null) {
			return link1==null?link2:link1;
		}
		LinkNode head = null;
		if (link1.data <= link2.data) {
			head = link1;
			head.next = merge(link1.next, link2);
		}else {
			head = link2;
			head.next = merge(link1, link2.next);
		}
		return head;
	}
	
	public LinkNode deleteLastKnode(int k) {
		LinkNode slow = head.next;
		LinkNode fast = head.next;
		while(k>0 && fast!=null) {
			fast = fast.next;
			k--;
		}
		while(fast != null) {
			fast = fast.next;
			slow = slow.next;
		}
		slow.next = slow.next.next;
		return head;
	}
	
	public String print() {
		if (head == null) {
			return "";
		}
		LinkNode node = head.next;
		StringBuffer sBuffer =  new StringBuffer();
		while (node != null) {
			sBuffer.append(node.data).append("->");
			node = node.next;
		}
		return sBuffer.toString();
	}
	
	public static void main(String[] args) {
		int[] array = new int[10];
		Random random = new Random();
		for(int i=0; i<array.length; i++) {
			array[i] = random.nextInt(100);
		}
		System.out.println("原始数组："+Arrays.toString(array));
		LinkAlgorithm linkAlgorithm =  new LinkAlgorithm();
		for (int i = 0; i < array.length; i++) {
			//linkAlgorithm.headAdd(array[i]);
			linkAlgorithm.tailAdd(array[i]);
		}
		System.out.println("尾插法的单链表："+linkAlgorithm.print());;
		linkAlgorithm.reverse();
		System.out.println("单链表的逆置："+linkAlgorithm.print());
		
	}
	
	
	

}
