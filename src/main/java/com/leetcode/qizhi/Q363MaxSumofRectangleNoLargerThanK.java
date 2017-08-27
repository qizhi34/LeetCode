package com.leetcode.qizhi;

import java.util.TreeSet;

/**
 * Created by qizhi on 2017/4/18.
 */
public class Q363MaxSumofRectangleNoLargerThanK {
	public static void main(String[] args) {
		int[][] matrix = {{3,  0, 1},{0, -2, 3}};
		int k=2;
		int output=maxSumSubmatrix1(matrix,k);
		System.out.println(output);
	}

	public static int maxSumSubmatrix1(int[][] matrix, int target) {
		int row=matrix.length;
		if(row==0) return 0;
		int col=matrix[0].length;
		int m=Math.min(row,col);
		int n=Math.max(row,col);
		boolean colIsBig=col>row;
		int res=Integer.MIN_VALUE;
		for (int i=0;i<m;i++){
			int[] array=new int[n];
			for (int j=i;j<m;j++){
				int val=0;
				TreeSet<Integer> treeSet=new TreeSet<Integer>();
				treeSet.add(0);
				for (int k=0;k<n;k++){
					array[k]=array[k]+(colIsBig==true?matrix[j][k]:matrix[k][j]);
					val=val+array[k];
					Integer sub=treeSet.ceiling(val-target);
					if(sub!=null){
						res=Math.max(res,val-sub);
						if(res==target)
							return res;
					}
					treeSet.add(val);
				}
			}
		}
		return res;
	}




	public static int maxSumSubmatrix(int[][] matrix, int target) {
		int row = matrix.length;
		if(row==0)return 0;
		int col = matrix[0].length;
		int m = Math.min(row,col);
		int n = Math.max(row,col);
		//indicating sum up in every row or every column
		boolean colIsBig = col>row;
		int res = Integer.MIN_VALUE;
		for(int i = 0;i<m;i++){
			int[] array = new int[n];
			// sum from row j to row i
			for(int j = i;j>=0;j--){
				int val = 0;
				TreeSet<Integer> set = new TreeSet<Integer>();
				set.add(0);
				//traverse every column/row and sum up
				for(int k = 0;k<n;k++){
					array[k]=array[k]+(colIsBig?matrix[j][k]:matrix[k][j]);
					val = val + array[k];
					//use  TreeMap to binary search previous sum to get possible result
					Integer subres =  set.ceiling( val-target);
					if(null!=subres){
						res=Math.max(res,val-subres);
						if(res==target)
							return res;
					}
					set.add(val);
				}
			}
		}
		return res;
	}

}
