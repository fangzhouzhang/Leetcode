public class _198HouseRobber {
	public int rob(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		Integer[] dp = new Integer[nums.length];
		return dfs(nums, nums.length - 1, dp);
	}

	private int dfs(int[] nums, int idx, Integer[] dp) {
		if (idx < 0) return 0;
		if (dp[idx] != null) return dp[idx];
		int max = Math.max(dfs(nums, idx - 1, dp), dfs(nums, idx - 2, dp) + nums[idx]);
		dp[idx] = max;
		return max;
	}
}
