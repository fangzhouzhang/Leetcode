public class _818RaceCar {
	public int racecar(int target) {
		if (target == 0) return 0;
		Integer[] dp = new Integer[target + 1];
		return dfs(target, dp, target);
	}

	private int dfs(int target, Integer[] dp, int rem) {
		if (dp[rem] != null) return dp[rem];
		int n = log2(rem);
		if ((1 << n) == rem + 1) {
			dp[rem] = n;
			return n;
		}
		int min = n + 1 + dfs(target, dp, (1 << n) - 1 - rem);
		for (int m = 0; m < n - 1; m++) {
			int cur = (1 << (n - 1)) - (1 << m);
			min = Math.min(min, n + 1 + m + dfs(target, dp, rem - cur));
		}
		dp[rem] = min;
		return dp[rem];
	}

	private int log2(int n) {
		return (int)Math.ceil(Math.log(n + 1) / Math.log(2));
	}
}
