package com.leetcode.qizhi;

/**
 * Created by qizhi on 2017/4/16.
 */
public class Q152MaximumProductSubarray {
	public static void main(String[] args) {
		int[] nums = {-1,0,-2,2};
		method2(nums);
	}

	/**
	 * 使用动态规划的方法
	 * @param nums
	 */
	private static void method2(int[] nums) {
		int ans=Integer.MIN_VALUE;
		if (nums == null || nums.length == 0) {
			ans=0;
		}
		int max = nums[0], min = nums[0];
		ans = nums[0];
		for (int i = 1; i < nums.length; i++) {
			int temp = max;
			max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
			min = Math.min(Math.min(temp * nums[i], min * nums[i]), nums[i]);
			ans=Math.max(ans,max);
		}
		System.out.println(ans);
//		return ans;
	}


	private static void method1(int[] nums) {

		int ans=Integer.MIN_VALUE;

		int[] proArr=new int[nums.length+1];
		proArr[0]=1;
		for (int i = 0; i < nums.length; i++) {
			if(proArr[i]==0)
				proArr[i+1]=nums[i];
			else
				proArr[i+1]=proArr[i]*nums[i];
		}
		int neg=Integer.MIN_VALUE;
		int pos=1;

		for (int i = 0; i < nums.length; i++) {
			if(proArr[i+1]>=0&&proArr[i+1]/pos>ans)
				ans=proArr[i+1]/pos;
			if(proArr[i+1]<0&&proArr[i+1]/neg>ans)
				if(neg==Integer.MIN_VALUE)
					ans=proArr[i+1];
				else
					ans=proArr[i+1]/neg;
			if(proArr[i+1]>0&&pos>proArr[i+1])
				pos=proArr[i+1];
			if(proArr[i+1]<0&&proArr[i+1]>neg)
				neg=proArr[i+1];
			if(proArr[i+1]==0){
				neg=Integer.MIN_VALUE;
				pos=1;
			}
		}
		System.out.println(ans);
//		return ans;
	}
}
