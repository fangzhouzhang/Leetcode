public class _935KnightDialer {
	private static int M = 1000000007;
	private int[][] map = {{4, 6}, {6, 8}, {7, 9}, {4, 8}, {0, 3, 9}, {}, {0, 1, 7}, {2, 6}, {1, 3}, {2, 4}};
	public int knightDialer(int n) {
		if (n == 1) return 10;
		Integer[][] dp = new Integer[10][n + 1];
		for (int i = 0; i < 10; i++) dp[i][2] = 2;
		dp[4][2] = 3;
		dp[6][2] = 3;
		// start from 5 == 0
		for (int i = 0; i < n + 1; i++) dp[5][i] = 0;
		long res = 0;
		for (int i = 0; i < 10; i++) {
			res = (res + dfs(i, n, dp)) % M;
		}
		return (int)res;
	}

	private int dfs(int cur, int remain, Integer[][] dp) {
		if (dp[cur][remain] != null) return dp[cur][remain];
		long res = 0;
		for (int x : map[cur]) {
			res = (res + dfs(x, remain - 1, dp)) % M;
		}
		return dp[cur][remain] = (int)res;
	}
}
