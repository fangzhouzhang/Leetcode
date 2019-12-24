public class _213HouseRobberII {
	public int rob(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		if (nums.length == 1) return nums[0];
		if (nums.length == 2) return Math.max(nums[0], nums[1]);
		int n = nums.length;
		int first = dfs(nums, 0, n - 2, new Integer[n]);
		int second = dfs(nums, 1, n - 1, new Integer[n]);
		return Math.max(first, second);
	}

	private int dfs(int[] nums, int start, int end, Integer[] dp) {
		if (start >= end + 1) return 0;
		if (dp[start] != null) return dp[start];
		int val1 = dfs(nums, start + 2, end, dp) + nums[start];
		int val2 = dfs(nums, start + 1, end, dp);
		dp[start] = Math.max(val1, val2);;
		return dp[start];
	}
}
