public class _1746MaximumSubarraySumAfterOneOperation {
	public int maxSumAfterOperation(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		int n = nums.length;
		int[][] dp = new int[n][2];
		dp[0][0] = nums[0];
		dp[0][1] = Math.max(nums[0], nums[0] * nums[0]);
		int res = Math.max(dp[0][0], dp[0][1]);
		for (int i = 1; i < n; i++) {
			dp[i][0] = Math.max(dp[i - 1][0] + nums[i], nums[i]);
			dp[i][1] = Math.max(nums[i] * nums[i], Math.max(dp[i - 1][0] + nums[i] * nums[i], dp[i - 1][1] + nums[i]));
			res = Math.max(res, Math.max(dp[i][0], dp[i][1]));
		}
		return res;
	}
}
