public class LongestContinuousIncreasingSubsequence {
	public int findLengthOfLCIS(int[] nums) {
		if (nums.length < 2) {
			return nums.length;
		}

		int[] dp = new int[nums.length];
		int max = 1;
		dp[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > nums[i - 1]) {
				dp[i] = dp[i - 1] + 1;
			} else {
				dp[i] = 1;
			}
			max = Math.max(max, dp[i]);
		}
		return max;
	}
}
