public class _322CoinChange {
	public int coinChange(int[] coins, int amount) {
		if (coins == null || coins.length == 0) return 0;
		Integer[][] dp = new Integer[amount + 1][coins.length];
		int res = dfs(coins, 0, amount, dp);
		return res == Integer.MAX_VALUE ? -1 : res;
	}

	private int dfs(int[] coins, int idx, int amount, Integer[][] dp) {
		if (amount == 0) {
			return 0;
		}
		if (idx == coins.length || amount < 0) return Integer.MAX_VALUE;
		if (dp[amount][idx] != null) return dp[amount][idx];
		int min = Integer.MAX_VALUE;
		for (int i = 0; amount - coins[idx] * i >= 0; i++) {
			int val = dfs(coins, idx + 1, amount - coins[idx] * i, dp);
			if (val == Integer.MAX_VALUE) continue;
			min = Math.min(min, val + i);
		}
		dp[amount][idx] = min;
		return min;
	}
}
