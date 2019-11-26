public class _64MinimumPathSum {
	/**
	 * @param grid: a list of lists of integers
	 * @return: An integer, minimizes the sum of all numbers along its path
	 * time:o(n * m) space:o(n * m)
	 */
	public int minPathSum(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
		int[][] dp = new int[grid.length][grid[0].length];
		dp[0][0] = grid[0][0];
		for (int i = 1; i < grid.length; i++) dp[i][0] = dp[i - 1][0] + grid[i][0];
		for (int i = 1; i < grid[0].length; i++) dp[0][i] = dp[0][i - 1] + grid[0][i];
		for (int i = 1; i < grid.length; i++) {
			for (int j = 1; j < grid[i].length; j++) {
				dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
			}
		}
		return dp[dp.length - 1][dp[0].length - 1];
	}

}
