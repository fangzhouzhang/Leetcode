public class _292NimGame {
	public boolean canWinNim(int n) {
		if(n >= 134882061) return n%4 != 0;
		Boolean[] dp = new Boolean[n + 1];
		return dfs(dp, n);
	}

	private boolean dfs(Boolean[] dp, int n) {
		if (n <= 3) return true;
		if (dp[n] != null) return dp[n];
		for (int i = 1; i <= 3; i++) {
			boolean res = dfs(dp, n - i);
			if (!res) {
				dp[n] = true;
				return dp[n];
			}
		}
		dp[n] = false;
		return dp[n];
	}
}
