package com.leetcode.qizhi;

/**
 * Created by qizhi on 2017/4/16.
 */
public class Q172FactorialTrailingZeroes {
	public static void main(String[] args) {
		int n = 5;
		System.out.println(trailingZeroes(n));
	}

	private static int trailingZeroes(int n) {
		int result=0;
		while (n!=0){
			n=n/5;
			result+=n;
		}
		return result;
	}


	private static int trailingZeroes1(int n) {
		return n==0?0:(n/5)+trailingZeroes1(n/5);
	}
}
