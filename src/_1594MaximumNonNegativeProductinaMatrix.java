public class _1594MaximumNonNegativeProductinaMatrix {
	int M = 1000000007;
	public int maxProductPath(int[][] grid) {
		int m = grid.length, n = grid[0].length;
		Pair[][] dp = new Pair[m][n];
		dp[0][0] = new Pair(grid[0][0], grid[0][0]);
		for (int i = 1; i < m; i++) {
			dp[i][0] = new Pair(dp[i - 1][0].min * grid[i][0], dp[i - 1][0].max * grid[i][0]);
		}
		for (int i = 1; i < n; i++) {
			dp[0][i] = new Pair(dp[0][i - 1].min * grid[0][i], dp[0][i - 1].max * grid[0][i]);
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (grid[i][j] >= 0) {
					dp[i][j] = new Pair(grid[i][j] * Math.min(dp[i][j - 1].min, dp[i - 1][j].min),  grid[i][j] * Math.max(dp[i][j - 1].max, dp[i - 1][j].max));
				} else {
					dp[i][j] = new Pair(grid[i][j] * Math.max(dp[i][j - 1].max, dp[i - 1][j].max),  grid[i][j] * Math.min(dp[i][j - 1].min, dp[i - 1][j].min));
				}
			}
		}
		return dp[m - 1][n - 1].max >= 0 ? (int)(dp[m - 1][n - 1].max % M) : -1;
	}


	class Pair {
		long min;
		long max;
		public Pair(long min, long max) {
			this.min = min;
			this.max = max;
		}
	}
}
