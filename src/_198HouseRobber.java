public class _198HouseRobber {
	public int rob(int[] nums) {
		if (null == nums || nums.length == 0) return 0;
		Integer[] dp = new Integer[nums.length];
		return dfs(dp, nums, 0);
	}

	private int dfs(Integer[] dp, int[] nums, int idx) {
		if (idx >= nums.length) return 0;
		if (dp[idx] != null) return dp[idx];
		int res = Math.max(dfs(dp, nums, idx + 2) + nums[idx], dfs(dp, nums, idx + 1));
		dp[idx] = res;
		return res;
	}
}
