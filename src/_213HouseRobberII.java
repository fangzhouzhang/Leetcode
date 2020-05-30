public class _213HouseRobberII {
	public int rob(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		int n = nums.length;
		if (n == 1) return nums[0];
		Integer[] dp = new Integer[n];
		Integer[] dp1 = new Integer[n];
		int m1 = dfs(nums, 0, n - 1, dp);
		int m2 = dfs(nums, 1, n, dp1);
		return Math.max(m1, m2);
	}

	private int dfs(int[] nums, int idx, int n, Integer[] dp) {
		if (idx >= n) return 0;
		if (dp[idx] != null) return dp[idx];
		int res = Math.max(dfs(nums, idx + 2, n, dp) + nums[idx], dfs(nums, idx + 1, n, dp));
		dp[idx] = res;
		return res;
	}
}
