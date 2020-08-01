public class _312BurstBalloons {
	public int maxCoins(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		Integer[][] dp = new Integer[nums.length][nums.length];
		return dfs(nums, 0, nums.length - 1, dp);
	}

	private int dfs(int[] nums, int start, int end, Integer[][] dp) {
		if (start > end) return 0;
		if (dp[start][end] != null) return dp[start][end];
		int max = -1;
		for (int i = start; i <= end; i++) {
			int left = start - 1 < 0? 1 : nums[start - 1];
			int right = end + 1 >= nums.length ? 1 : nums[end + 1];
			max = Math.max(max, dfs(nums, start, i - 1,dp) + dfs(nums, i + 1, end, dp) + left * right * nums[i]);
		}
		dp[start][end] = max;
		return max;
	}
}
