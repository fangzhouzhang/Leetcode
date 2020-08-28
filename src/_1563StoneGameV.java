public class _1563StoneGameV {
	public int stoneGameV(int[] stoneValue) {
		if (stoneValue == null || stoneValue.length == 0) return 0;
		int sum = 0, n = stoneValue.length;
		int[] prefix = new int[n + 1];
		Integer[][] dp = new Integer[n][n];
		for (int i = 0; i < n; i++) {
			sum += stoneValue[i];
			prefix[i + 1] = sum;
		}
		return dfs(dp, 0, n - 1, prefix);
	}

	private int dfs(Integer[][] dp, int start, int end, int[] prefix) {
		if (end - start == 1) return Math.min(prefix[start + 1] - prefix[start], prefix[end + 1] - prefix[end]);
		if (end == start) return 0;
		if (dp[start][end] != null) return dp[start][end];
		int res = 0;
		//[start, x] [x + 1, end] , x in [start + 1, end - 1]
		for (int x = start; x < end; x++) {
			int firstHalf = prefix[x + 1] - prefix[start], secondHalf = prefix[end + 1] - prefix[x + 1];

			if (firstHalf < secondHalf) {
				res = Math.max(res, dfs(dp, start, x, prefix) + firstHalf);
			} else if (firstHalf > secondHalf) {
				res = Math.max(res, dfs(dp, x + 1, end, prefix) + secondHalf);
			} else {
				res = Math.max(res, dfs(dp, start, x, prefix) + firstHalf);
				res = Math.max(res, dfs(dp, x + 1, end, prefix) + secondHalf);
			}
		}
		return dp[start][end] = res;
	}
}
