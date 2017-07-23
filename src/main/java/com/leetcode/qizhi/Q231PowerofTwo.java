package com.leetcode.qizhi;

/**
 * Created by qizhi on 2017/7/20.
 */
public class Q231PowerofTwo {
	public static void main(String[] args) {
		int ans=1;
		boolean result=method2(ans);
		System.out.println(result);
	}

	private static boolean method3(int n) {
		return n>0 && (1073741824 % n == 0);
	}

	private static boolean method2(int n) {
		if(n<=0)
			return false;
//		return !(n&(n-1));
		return (n&(n-1))==0;
	}

	//Time Limit Exceeded
	private static boolean method1(int n) {
		if(n==1){
			return true;
		}
		boolean ispower=((n%2)==0);
		while(ispower&&((n=n/2)!=1))
			ispower=((n%2)==0);
		return ispower;
	}
}
