package com.jellard.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class TreeAlgorithm {
	
	static class BinTree{
		int data;
		BinTree left;
		BinTree right;
		
		public BinTree(int data) {
			this.data = data;
		}
    }
	
	private BinTree root;
	
	public BinTree buildBinTree(BinTree node,int data) {
		if (root == null) {
			root = new BinTree(data);
		}else {
			if (data < node.data) {
				if (node.left == null) {
					node.left = new BinTree(data);
				}else {
					buildBinTree(node.left, data);
				}
			}else {
				if (node.right == null) {
					node.right = new BinTree(data);
				}else {
					buildBinTree(node.right, data);
				}
			}
		}
		return root;
	}
	String pre = "[";
	public void preTraversal(BinTree node) {
		if (node == null) {
			return;
		}
		pre += node.data+" ,";
		preTraversal(node.left);
		preTraversal(node.right);
	}
	
	public List<Integer> preTraversal2(BinTree root){
		List<Integer> list =  new ArrayList<Integer>();
		if (root == null) {
			return list;
		}
		Stack<BinTree> stack =  new Stack<>();
		stack.push(root);
		while(!stack.empty()) {
			BinTree temp = stack.pop();
			if (temp.right != null) {
				stack.push(temp.right);
			}
			if (temp.left != null) {
				stack.push(temp.left);
			}
			list.add(temp.data);
		}
		return list;
	}
	String mid = "[";
	public void midTraversal(BinTree node) {
		if (node == null) {
			return;
		}
		midTraversal(node.left);
		mid+=node.data+" ,";
		midTraversal(node.right);
	}
	
	public List<Integer> midTraversal2(BinTree root){
		List<Integer> list = new ArrayList<>();
		if (root == null) {
			return list;
		}
		Stack<BinTree> stack =  new Stack<>();
		BinTree cur = root;
		while(cur != null || !stack.isEmpty()) {
			if (cur != null) {
				stack.push(cur);
				cur = cur.left;
			}else {
				BinTree temp = stack.pop();
				list.add(temp.data);
				cur = temp.right;
			}
		}
		return list;
	}
	
	public int maxDepth(BinTree root) {
        if(root==null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left,right)+1;
	}
	
	public boolean childNode(BinTree root,BinTree temp) {
		if(root == null) {
			return false;
		}
		if (root== temp) {
			return true;
		}
		if (childNode(root.left, temp) || childNode(root.right, temp)) {
			return true;
		}
		return false;
	}
	
	public BinTree lowestCommonAncestor(BinTree root, BinTree p, BinTree q) {
        if(root == null || root == p || root == q){
            return root;
        }
        BinTree left = lowestCommonAncestor(root.left,p,q);
        BinTree right = lowestCommonAncestor(root.right,p,q);
        if(left!=null && right!=null){
            return root;
        }
        return left!=null?left:right;
    }
	
	public static void main(String[] args) {
		int[] array = new int[6];
		Random random = new Random();
		for(int i=0; i<array.length; i++) {
			array[i] = random.nextInt(100);
		}
		System.out.println("原始数组："+Arrays.toString(array));
		TreeAlgorithm treeAlgorithm = new  TreeAlgorithm();
		for (int i = 0; i < array.length; i++) {
			treeAlgorithm.buildBinTree(treeAlgorithm.root, array[i]);
		}
		treeAlgorithm.preTraversal(treeAlgorithm.root);
		System.out.println("递归先序:"+treeAlgorithm.pre+"]");
		List<Integer> list = treeAlgorithm.preTraversal2(treeAlgorithm.root);
		System.out.println("非递归先序："+list);
		treeAlgorithm.midTraversal(treeAlgorithm.root);
		System.out.println("递归中序:"+treeAlgorithm.mid+"]");
		list = treeAlgorithm.midTraversal2(treeAlgorithm.root);
		System.out.println("非递归中序："+list);
		
		
	    //https://blog.csdn.net/weixin_42069523/article/details/89467262
	}

}
