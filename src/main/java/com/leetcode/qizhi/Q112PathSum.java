package com.leetcode.qizhi;

/**
 * Created by qizhi on 2017/4/18.
 */
public class Q112PathSum {
	public static void main(String[] args) {
		TreeNode treeNode=new TreeNode(10);
		int sum=22;
		boolean output=hasPathSum(treeNode,sum);
		System.out.println(output);
	}

	public static boolean hasPathSum(TreeNode root, int sum) {
		return true;
	}

	public static class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}

}
