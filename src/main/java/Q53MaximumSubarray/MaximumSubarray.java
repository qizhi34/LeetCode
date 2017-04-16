package Q53MaximumSubarray;

/**
 * Created by qizhi on 2017/4/16.
 */
public class MaximumSubarray {
	public static int main(String[] args) {
		int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
//		for (int i=0;i<nums.length;i++){
//			System.out.println(nums[i]);
//		}

		return method3(nums);
	}

	/**
	 * 用动态规划
	 * @param nums
	 */
	private static int method3(int[] nums) {
		if(nums==null||nums.length==0){
			return 0;
		}
		int ans = nums[0];
		int max=nums[0];
		for (int i = 1; i < nums.length; i++) {
			max=Math.max(nums[i],max+nums[i]);
			ans=Math.max(max,ans);
		}
		return ans;
//		return ans;
	}

	private static void method2(int[] nums) {
		int ans = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			if (sum < 0)
				sum = 0;
			if (sum + nums[i] > ans)
				ans = sum + nums[i];
			sum += nums[i];
		}
		System.out.println(ans);
//		return ans;
	}

	private static void method1(int[] nums) {
		int sumArr[] = new int[nums.length + 1];
		sumArr[0] = 0;
		for (int i = 0; i < nums.length; i++) {
			sumArr[i + 1] = sumArr[i] + nums[i];
		}
		int ans = Integer.MIN_VALUE;
		int minPre = 0;
		for (int i = 0; i < nums.length; i++) {
			if (sumArr[i] < minPre) {
				minPre = sumArr[i];
			}
			if (sumArr[i + 1] - minPre > ans) {
				ans = sumArr[i + 1] - minPre;
			}
		}
		System.out.println(ans);
//		return ans;
	}
}
