public class _410SplitArrayLargestSum {
	public int splitArray(int[] nums, int m) {
		int[] prefix = new int[nums.length + 1];
		int sum = 0;
		for (int i = 1; i < prefix.length; i++) {
			sum += nums[i - 1];
			prefix[i] = sum;
		}

		int[][] dp = new int[m + 1][nums.length];
		for (int i = 0; i < nums.length; i++) {
			dp[1][i] = prefix[i + 1];
		}

		for (int i = 2; i <= m; i++) {
			for (int j = i - 1; j < nums.length; j++) {
				int min = Integer.MAX_VALUE;
				for (int k = 0; k < j; k++) {
					int max = Math.max(dp[i - 1][k], prefix[j + 1] - prefix[k + 1]);
					min = Math.min(min, max);
				}
				dp[i][j] = min;
			}
		}
		return dp[m][nums.length - 1];
	}

	public int splitArray1(int[] nums, int m) {
		long[] prefix = new long[nums.length + 1];
		long sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			prefix[i + 1] = sum;
		}

		Long[][] dp = new Long[m + 1][nums.length];



		return (int)dfs(dp, m, nums.length - 1, prefix);
	}

	private long dfs(Long[][] dp, int m, int end, long[] prefix) {
		if (end < 0) return 0;
		if (m > end + 1) return 0;
		if (m == 1) return prefix[end + 1];
		if (dp[m][end] != null) return dp[m][end];

		long min = Integer.MAX_VALUE;
		for (int i = 0; i <= end; i++) {
			min = Math.min(min, Math.max(dfs(dp, m - 1, i, prefix), prefix[end + 1] - prefix[i + 1]));
		}

		dp[m][end] = min;
		return dp[m][end];
	}
}
