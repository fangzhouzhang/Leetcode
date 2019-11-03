import java.util.Arrays;

public class LongestIncreasingSubsequence {
	public int lengthOfLIS(int[] nums) {
		if (nums.length <= 1) return nums.length;
		//dp[i] means longest increasing subsequence including nums[i]
		int[] dp = new int[nums.length];
		Arrays.fill(dp, 1);
		//max is global max value
		int max = 1;
		for (int i = 1; i < nums.length; i++) {
			int cur = getCurMax(dp, nums, i);
			max = Math.max(max, cur);
		}
		return max;
	}

	private int getCurMax(int[] dp, int[] nums, int k) {
		int tmp = -1;
		for (int i = 0; i < k; i++) {
			if (nums[k] > nums[i]) {
				tmp = Math.max(tmp, dp[i] + 1);
			}
		}
		if (tmp != -1) dp[k] = tmp;
		return tmp;
	}
}
