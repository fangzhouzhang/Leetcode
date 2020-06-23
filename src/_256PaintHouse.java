public class _256PaintHouse {
	public int minCost(int[][] costs) {
		if (costs == null || costs.length == 0) return 0;
		int rows = costs.length;
		int cols = costs[0].length;
		Integer[][] dp = new Integer[rows][cols];
		return dfs(costs, 0, 0, dp);
	}

	private int dfs(int[][] costs, int start, int pre, Integer[][] dp) {
		if (start == costs.length) return 0;
		if (dp[start][pre] != null) return dp[start][pre];
		int min = Integer.MAX_VALUE;
		if (start == 0) {
			for (int i = 0; i < costs[start].length; i++) {
				min = Math.min(min, dfs(costs, start + 1, i, dp) + costs[start][i]);
			}
		} else {
			for (int i = 0; i < costs[start].length; i++) {
				if (i == pre) continue;
				min = Math.min(min, dfs(costs, start + 1, i, dp) + costs[start][i]);
			}
		}
		dp[start][pre] = min;
		return min;
	}
}
