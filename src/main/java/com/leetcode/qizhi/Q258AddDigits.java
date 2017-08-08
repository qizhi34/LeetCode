package com.leetcode.qizhi;

/**
 * Created by qizhi on 2017/4/16.
 */
public class Q258AddDigits {
	public static void main(String[] args) {
		int n = 38;
		System.out.println(addDigits2(n));
	}

	private static int addDigits2(int num) {
		return 1+(num-1)%9;
	}

	private static int addDigits(int num) {
		int result=num;
		while (result>=10){
			result=0;
			while (num!=0){
				result+=num%10;
				num=num/10;
			}
			num=result;
		}


		return result;
	}
}
