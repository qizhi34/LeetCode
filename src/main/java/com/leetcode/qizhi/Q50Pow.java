package com.leetcode.qizhi;

import java.util.PriorityQueue;

/**
 * Created by qizhi on 2017/4/18.
 */
public class Q50Pow {
	public static void main(String[] args) {
		double x = 0.5;
		int n=2;
		double output=myPow(x,n);
		System.out.println(output);
	}

	public static double myPow2(double x, int n) {
		double ans=1;
		long absN=Math.abs((long)n);
		while(absN>0){
			if((absN&1)==1)
				ans*=x;
			x*=x;
			absN>>=1;
		}
		return n>0?ans:1/ans;
	}

	public static double myPow(double x, int n) {
		if(n==0)
			return 1;
		if(n<0) return 1/x * myPow(1/x, -(n+1));

		return n%2==0?myPow(x*x,n/2):x*myPow(x*x,n/2);
	}

}
