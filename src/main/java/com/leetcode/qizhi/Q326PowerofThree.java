package com.leetcode.qizhi;

/**
 * Created by qizhi on 2017/4/16.
 */
public class Q326PowerofThree {
	public static void main(String[] args) {
		System.out.println();
		int n = 3;
		System.out.println(method5(n));
	}

	private static boolean method5(int n) {
		return n > 0 && 1162261467 % n == 0;
	}

	private static boolean method4(int n) {
		return (Math.log10(n)/Math.log10(3))%1==0;
	}

	private static boolean method3(int n) {
		return Integer.toString(n,3).matches("^10*");
	}

	private static boolean method2(int n) {
		if(n<1)
			return false;
		while(n%3==0){
			n=n/3;
		}
		if(n==1)
			return true;

		return false;
	}

	private static boolean method1(int n) {
		if(n==0)
			return false;
		if(n==1)
			return true;
		while(n!=0){
			if(n%3!=0)
				return false;
			n=n/3;
			if(n==1)
				return true;
		}

		return true;
	}
}
