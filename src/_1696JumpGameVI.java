public class _1696JumpGameVI {
	int k = 0;
	public int maxResult(int[] nums, int k) {
		if (nums == null || nums.length == 0) return 0;
		this.k = k;
		Integer[] dp = new Integer[nums.length];
		return dfs(nums, 0, dp);
	}

	private int dfs(int[] nums, int idx, Integer[] dp) {
		if (idx == nums.length - 1) return nums[idx];
		if (dp[idx] != null) return dp[idx];
		int res = Integer.MIN_VALUE;
		for (int i = 1; i <= k && i + idx <= nums.length - 1; i++) {
			res = Math.max(res, dfs(nums, i + idx, dp) + nums[idx]);
		}
		return dp[idx] = res;
	}
}
