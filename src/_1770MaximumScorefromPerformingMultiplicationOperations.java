public class _1770MaximumScorefromPerformingMultiplicationOperations {
	public int maximumScore(int[] nums, int[] multipliers) {
		if (nums == null || multipliers == null || nums.length == 0 || multipliers.length == 0) return 0;
		int n = nums.length;
		int m = multipliers.length;
		// dp[i][j] means the max score, from [i, n - j + i - 1], starting from j-th on multipliers
		// j is the used total number, i is the left-side total used number, j - i is the right-side used number
		// length of [i, r] + j = n, r - i + 1 + j = n, r = n - j + i - 1
		Integer[][] dp = new Integer[m][m];
		return dfs(nums, multipliers, dp, 0, 0);
	}

	private int dfs(int[] nums, int[] multipliers, Integer[][] dp, int i, int j) {
		if (j == multipliers.length) return 0;
		if (dp[i][j] != null) return dp[i][j];
		int res = Integer.MIN_VALUE, n = nums.length;
		res = Math.max(res, dfs(nums, multipliers, dp, i + 1, j + 1) + nums[i] * multipliers[j]);
		res = Math.max(res, dfs(nums, multipliers, dp, i, j + 1) + nums[n - j + i - 1] * multipliers[j]);
		return dp[i][j] = res;
	}
}
