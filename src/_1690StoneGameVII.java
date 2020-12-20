public class _1690StoneGameVII {
	public int stoneGameVII(int[] stones) {
		if (stones == null || stones.length == 0) return 0;
		int n = stones.length;
		int[] prefix = new int[n + 1];
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += stones[i];
			prefix[i + 1] = sum;
		}
		Integer[][] dp = new Integer[n][n];
		return -1 * dfs(stones, 0, n - 1, dp, prefix);
	}

	private int dfs(int[] stones, int start, int end, Integer[][] dp, int[] prefix) {
		if (start == end) return 0;
		if (dp[start][end] != null) return dp[start][end];
		int res = Integer.MIN_VALUE;
		res = Math.max(res, dfs(stones, start + 1, end, dp, prefix) + prefix[end + 1] - prefix[start + 1]);
		res = Math.max(res, dfs(stones, start, end - 1, dp, prefix) + prefix[end] - prefix[start]);
		return dp[start][end] = -1 * res;
	}
}
