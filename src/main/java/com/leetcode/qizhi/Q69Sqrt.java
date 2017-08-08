package com.leetcode.qizhi;

/**
 * Created by qizhi on 2017/4/16.
 */
public class Q69Sqrt {
	public static void main(String[] args) {
		int x=4;

		System.out.println(mySqrt(x));
	}

	public static int mySqrt(int x) {
		long r=x;
		while(r*r>x)
			r=(r+x/r)/2;
		return (int)r;
	}

	public static int mySqrt3(int x) {
		if (x == 0)
			return 0;
		int left = 1, right = x;
		while (true) {
			int mid = left + (right - left)/2;
			if (mid > x/mid) {
				right = mid - 1;
			} else {
				if (mid + 1 > x/(mid + 1))
					return mid;
				left = mid + 1;
			}
		}
	}

	public static int mySqrt2(int x) {
		if(x==0)
			return 0;
		int left=1,right=(int)(((long)x+1)/2);
		int mid=(left+right)/2;
		while(left<right){
			if(mid>x/mid){
				right=mid-1;
			}else{
				if((mid+1)>x/(mid+1)){
					break;
				}
				left=mid+1;
			}
			mid=(left+right)/2;
		}
		return mid;
	}

	public static int mySqrt1(int x) {
		int res=0;
		long tmp=0;
		for (int i = 0; i <= ((long)x+1)/2; i++) {
			tmp=(long)i*i;
			if(tmp<=x)
				res=i;
			if(tmp>x)
				break;
		}
		return res;
	}
}
