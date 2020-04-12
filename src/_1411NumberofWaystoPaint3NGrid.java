public class _1411NumberofWaystoPaint3NGrid {
	private int M = 1000000007;
	public int numOfWays(int n) {
		Integer[][][][] dp = new Integer[n + 1][3][3][3];
		return dfs(dp, 1, -1, -1, -1);
	}

	private int dfs(Integer[][][][] dp, int idx, int i, int j, int k) {
		if (idx == dp.length) return 1;
		if (i != -1 && j != -1 && k != -1 && dp[idx][i][j][k] != null) return dp[idx][i][j][k];
		int res = 0;
		for (int x = 0; x < 3; x++) {
			if (x != i) {
				for (int y = 0; y < 3; y++) {
					if (y != j && y != x) {
						for (int z = 0; z < 3; z++) {
							if (z != k && z != y) {
								res = (res + dfs(dp, idx + 1, x, y, z)) % M;
							}
						}
					}
				}
			}
		}
		if (i != -1 && j != -1 && k != -1) dp[idx][i][j][k] = res;
		return res;
	}
}
