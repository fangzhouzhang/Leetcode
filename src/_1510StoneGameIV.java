public class _1510StoneGameIV {
	public boolean winnerSquareGame(int n) {
		if (n == 0) return false;
		Boolean[] dp = new Boolean[n + 1];
		return dfs(n, dp);
	}

	private boolean dfs(int n, Boolean[] dp) {
		if (n == 0) return false;
		if (dp[n] != null) return dp[n];
		for (int i = 1; i * i <= n; i++) {
			boolean res = dfs(n - i * i, dp);
			if (!res) {
				dp[n] = true;
				return true;
			}
		}
		dp[n] = false;
		return false;
	}
}
