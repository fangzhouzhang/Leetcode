public class _1406StoneGameIII {
	public String stoneGameIII(int[] stoneValue) {
		int n = stoneValue.length;
		Integer[] dp = new Integer[n];
		int res = dfs(stoneValue, dp, 0);
		if (res == 0) return "Tie";
		else if (res < 0) return "Alice";
		else return "Bob";
	}

	private int dfs(int[] stoneValue, Integer[] dp, int idx) {
		if (idx == stoneValue.length) return 0;
		if (dp[idx] != null) return dp[idx];
		int res = Integer.MIN_VALUE, sum = 0;
		for (int k = 0; k < 3 && idx + k < stoneValue.length; k++) {
			sum += stoneValue[idx + k];
			res = Math.max(res, sum + dfs(stoneValue, dp, idx + k + 1));
		}
		return dp[idx] = -1 * res;
	}
}
