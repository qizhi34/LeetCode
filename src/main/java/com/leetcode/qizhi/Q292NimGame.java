package com.leetcode.qizhi;

/**
 * Created by qizhi on 2017/4/16.
 */
public class Q292NimGame {
	public static void main(String[] args) {
		int n = 38;
		System.out.println(canWinNim(n));
	}


	public static boolean canWinNim(int n) {
		return n%4!=0;
	}

	public static boolean canWinNim2(int n) {
		return (n&3)!=0;
	}
}
