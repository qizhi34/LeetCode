package com.leetcode.qizhi;

import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * Created by qizhi on 2017/4/18.
 */
public class Q378KthSmallestElementInASortedMatrix {
	public static void main(String[] args) {
		int[][] matrix = {{2000000000}};
		int k=1;
		int output=kthSmallest2(matrix,k);
		System.out.println(output);
	}

	public static int kthSmallest3(int[][] matrix, int k) {
		int n = matrix.length;
		int lo = matrix[0][0], hi = matrix[n - 1][n - 1];
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			int count = getLessEqual(matrix, mid);
			if (count < k) lo = mid + 1;
			else hi = mid - 1;
		}
		return lo;
	}

	private static int getLessEqual(int[][] matrix, int val) {
		int res = 0;
		int n = matrix.length, i = n - 1, j = 0;
		while (i >= 0 && j < n) {
			if (matrix[i][j] > val) i--;
			else {
				res += i + 1;
				j++;
			}
		}
		return res;
	}

	public static int kthSmallest2(int[][] matrix, int k) {
		int row=matrix.length;
		if(row==0){
			return 0;
		}
		int col=matrix[0].length;
		int low=matrix[0][0];
		int high=matrix[row-1][col-1];
		while(low<=high){
			int mid=low+(high-low)/2;
			int count=0;
			for(int i=0;i<row;i++){
				int j=col-1;
				while(j>=0&&matrix[i][j]>mid)
					j--;
				count+=(j+1);
			}
			if(count<k)
				low=mid+1;
			else
				high=mid-1;
		}
		return low;
	}

	public static int kthSmallest1(int[][] matrix, int k) {
		int row=matrix.length;
		if(row==0){
			return 0;
		}
		int col=matrix[0].length;
		int low=matrix[0][0];
		int high=matrix[row-1][col-1];
		while(low<high){
			int mid=(high+low)/2;
			int count=0;
			for(int i=0;i<row;i++){
				int j=col-1;
				while(j>=0&&matrix[i][j]>mid)
					j--;
				count+=(j+1);
			}
			if(count<k)
				low=mid+1;
			else
				high=mid;
		}
		return low;
	}

	public static int kthSmallest(int[][] matrix, int k) {
		int row=matrix.length;
		if(row==0){
			return 0;
		}
		int col=matrix[0].length;

		PriorityQueue<Tuple> priorityQueue=new PriorityQueue<Tuple>();

		for(int i=0;i<col;i++){
			Tuple tuple=new Tuple(0,i,matrix[0][i]);
			priorityQueue.offer(tuple);
		}

		for(int j=0;j<k-1;j++) {
			Tuple tmpTuple = priorityQueue.poll();
			if (tmpTuple.x >= row - 1)
				continue;
			Tuple addTuple = new Tuple(tmpTuple.x + 1, tmpTuple.y, matrix[tmpTuple.x + 1][tmpTuple.y]);
			priorityQueue.offer(addTuple);
		}

		return priorityQueue.poll().value;
	}

	static class Tuple implements Comparable<Tuple>{
		int x;
		int y;
		int value;

		public Tuple(int x,int y,int value){
			this.x=x;
			this.y=y;
			this.value=value;
		}

		@Override
		public int compareTo(Tuple o) {
			return this.value-o.value;
		}
	}

}
