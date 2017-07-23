package com.leetcode.qizhi;

/**
 * Created by qizhi on 2017/5/28.
 */
public class Q7ReverseInteger {
	/**
	 * int   -2147483648～2147483647
	 * @param args
	 */
	public static void main(String[] args) {
		int ans=-123;
		int result=method2(ans);
		System.out.println(result);
	}

	private static int method2(int x) {
		int ans=0;
		while(x!=0){
			int tail = x%10;
			int ansnew=ans*10+tail;
			if(ansnew/10!=ans)
				return 0;
			x=x/10;
			ans=ansnew;
		}
		return ans;
	}

	private static int method1(int x) {
		int ans=0;
		boolean ispos=true;
		if(x<0){
			ispos=false;
			if(x==Integer.MIN_VALUE)
				return 0;
			x=-x;
		}
		ans=x%10;
		while((x=x/10)!=0){
			if(ispos&&(ans>Integer.MAX_VALUE/10||(ans==Integer.MAX_VALUE/10&&x>Integer.MAX_VALUE%10)))
				return 0;
			if(!ispos&&(ans>Integer.MAX_VALUE/10||(ans==Integer.MIN_VALUE*-1/10&&x>Integer.MIN_VALUE%10)))
				return 0;
			ans=ans*10+x%10;
		}
		if(!ispos){
			ans=-ans;
		}
//		System.out.println(ans);
		return ans;
	}
}
