import java.util.Arrays;

public class _1547MinimumCosttoCutaStick {
	public int minCost(int n, int[] cuts) {
		if (cuts == null || cuts.length == 0) return 0;
		Integer[][] dp = new Integer[cuts.length + 1][cuts.length + 1];
		Arrays.sort(cuts);
		return dfs(cuts, 0, cuts.length - 1, 0, n, dp);
	}

	private int dfs(int[] cuts, int i, int j, int l, int r, Integer[][] dp) {
		if (i > j || i < 0 || j >= cuts.length) return 0;
		if (i == j) return r - l;
		if (dp[i][j] != null) return dp[i][j];
		int res = Integer.MAX_VALUE;
		for (int k = i; k <= j; k++) {
			res = Math.min(res, r - l + dfs(cuts, i, k - 1, l, cuts[k], dp) + dfs(cuts, k + 1, j, cuts[k], r, dp));
		}
		dp[i][j] = res;
		return res;
	}
}
