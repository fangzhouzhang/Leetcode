public class _1473PaintHouseIII {
	public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
		if (houses == null || houses.length == 0) return 0;
		Integer[][][] dp = new Integer[m][n + 1][target + 1];
		int res = dfs(houses, cost, 0, 0, target, dp);
		return res == Integer.MAX_VALUE ? -1 : res;
	}

	private int dfs(int[] houses, int[][] cost, int h_idx, int c, int target, Integer[][][] dp) {
		if (h_idx == houses.length && target == 0) return 0;
		if (h_idx >= houses.length || target < 0) return Integer.MAX_VALUE;
		if (dp[h_idx][c][target] != null) return dp[h_idx][c][target];
		int min = Integer.MAX_VALUE;
		if (houses[h_idx] != 0) {
			if (c == houses[h_idx]) {
				int val = dfs(houses, cost, h_idx + 1, houses[h_idx], target, dp);
				if (val != Integer.MAX_VALUE) {
					min = Math.min(val, min);
				}
			} else {
				int val = dfs(houses, cost, h_idx + 1, houses[h_idx], target - 1, dp);
				if (val != Integer.MAX_VALUE) {
					min = Math.min(val, min);
				}
			}
		} else {
			for (int i = 0; i < cost[h_idx].length; i++) {
				if (c == i + 1) {
					int val = dfs(houses, cost, h_idx + 1, i + 1, target, dp);
					if (val != Integer.MAX_VALUE) {
						min = Math.min(val + cost[h_idx][i], min);
					}
				} else {
					int val = dfs(houses, cost, h_idx + 1, i + 1, target - 1, dp);
					if (val != Integer.MAX_VALUE) {
						min = Math.min(val + cost[h_idx][i], min);
					}
				}
			}
		}
		dp[h_idx][c][target] = min;
		return dp[h_idx][c][target];
	}
}
