package com.leetcode.qizhi;

/**
 * Created by qizhi on 2017/4/16.
 */
public class Q191Numberof1Bits {
	public static void main(String[] args) {
		int n = 3;
		System.out.println(method1(n));
	}

	private static int method3(int n) {
		int res=0;
		int mask=1;
		for (int i = 0; i < 32; i++) {
			if((n&mask)==mask)
				res++;
			mask=mask<<1;
		}
		return res;
	}


	private static int method2(int n) {
		int res=0;
		while(n!=0){
			res++;
			n=n&(n-1);
		}
		return res;
	}

	//  2147483648 (10000000000000000000000000000000)
	//unsigned   int   0～4294967295
	//int   -2147483648～2147483647
	private static int method1(int n) {
		int res=0;
		while(n!=0){
			if(n%2==1){
				res++;
			}
			n=n>>1;
		}
		return res;
	}
}
