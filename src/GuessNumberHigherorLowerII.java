public class GuessNumberHigherorLowerII {
	public int getMoneyAmount(int n) {
		Integer[][] dp = new Integer[n + 1][n + 1];
		return dfs(dp, 0, n);
	}

	private int dfs(Integer[][] dp, int start, int end) {
		if (start >= end) {
			return 0;
		}
		if (dp[start][end] != null) {
			return dp[start][end];
		}
		int res = Integer.MAX_VALUE;
		for (int i = start; i <= end; i++) {
			int tmp = i + Math.max(dfs(dp, start, i - 1), dfs(dp, i + 1, end));
			res = Math.min(res, tmp);
		}
		dp[start][end] = res;
		return res;
	}
}
