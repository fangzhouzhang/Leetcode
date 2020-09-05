public class _1029TwoCityScheduling {
	public int twoCitySchedCost(int[][] costs) {
		if (costs == null || costs.length == 0) return 0;
		int n = costs.length;
		Integer[][][] dp = new Integer[n][n / 2 + 1][n / 2 + 1];
		return dfs(dp, 0, n / 2, n / 2, costs);
	}

	private int dfs(Integer[][][] dp, int idx, int a, int b, int[][] costs) {
		if (idx == costs.length && a == 0 && b == 0) return 0;
		if (idx == costs.length && (a != 0 || b != 0)) return Integer.MAX_VALUE;
		if (dp[idx][a][b] != null) return dp[idx][a][b];
		int res = Integer.MAX_VALUE;
		if (a > 0) {
			int val = dfs(dp, idx + 1, a - 1, b, costs);
			if (val != Integer.MAX_VALUE) {
				res = Math.min(res, val + costs[idx][0]);
			}
		}
		if (b > 0) {
			int val = dfs(dp, idx + 1, a, b - 1, costs);
			if (val != Integer.MAX_VALUE) {
				res = Math.min(res, val + costs[idx][1]);
			}
		}
		return dp[idx][a][b] = res;
	}
}
