package com.leetcode.qizhi;

import java.util.Stack;

/**
 * Created by qizhi on 2017/4/18.
 */
public class Q410SplitArrayLargestSum {
	public static void main(String[] args) {
		int[] nums = {1,Integer.MAX_VALUE-1};
		int m=1;
		int output=splitArray(nums,m);
		System.out.println(output);
	}

	public static int splitArray(int[] nums, int m) {
		int max = 0; long sum = 0;
		for (int num : nums) {
			max = Math.max(num, max);
			sum += num;
		}
		if (m == 1) return (int)sum;
		//binary search
		long l = max; long r = sum;
		while (l <= r) {
			long mid = (l + r)/ 2;
			if (valid(mid, nums, m)) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return (int)l;
	}
	public static boolean valid(long target, int[] nums, int m) {
		int count = 1;
		long total = 0;
		for(int num : nums) {
			total += num;
			if (total > target) {
				total = num;
				count++;
				if (count > m) {
					return false;
				}
			}
		}
		return true;
	}


	public static int splitArray1(int[] nums, int m) {
		long left=Integer.MIN_VALUE;
		long right=0;
		int target=0;
		for (int i = 0; i < nums.length; i++) {
			if(nums[i]>left)
				left=nums[i];
			right+=nums[i];
		}
		int mid=(int)((left+right)/2);
		while(left<=right){
			mid=(int)((left+right)/2);
			if(isvalid(nums,m,mid)){
				target=mid;
				right=mid-1;
			}
			else
				left=mid+1;
		}
		return target;
	}

	public static boolean isvalid(int[] nums,int m,int mid){
		int count=1;
		int temptotal=0;
		for (int i = 0; i < nums.length; i++) {
			temptotal+=nums[i];
			if(temptotal>mid){
				count++;
				temptotal=nums[i];
			}
			if(count>m){
				return false;
			}
		}
		return true;
	}
}
