public class _688KnightProbabilityinChessboard {
	private int[][] dirs = {{-2,-1},{-1,-2},{1,-2},{2,-1},{2,1},{1,2},{-1,2},{-2,1}};
	public double knightProbability(int N, int K, int r, int c) {
		Double[][][] dp = new Double[N][N][K + 1];
		return dfs(N, K, r, c, dp, 1);
	}

	private double dfs(int N, int K, int r, int c, Double[][][] dp, double p) {
		if (K == 0) return p;
		if (dp[r][c][K] != null) return dp[r][c][K];
		double res = 0;
		for (int[] dir : dirs) {
			int rr = r + dir[0];
			int cc = c + dir[1];
			if (rr < 0 || rr >= N || cc < 0 || cc >= N) continue;
			res += dfs(N, K - 1, rr, cc, dp, p / 8);
		}
		return dp[r][c][K] = res;
	}
}
