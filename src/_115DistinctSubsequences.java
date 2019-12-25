public class _115DistinctSubsequences {
	public int numDistinct(String s, String t) {
		if (s == null || t == null) return 0;
		Integer[][] dp = new Integer[s.length()][t.length()];
		return dfs(s.toCharArray(), t.toCharArray(), 0, 0, dp);
	}

	private int dfs(char[] s, char[] t, int idxs, int idxt, Integer[][] dp) {
		if (idxt == t.length) return 1;
		if (idxs == s.length) return 0;
		if (dp[idxs][idxt] != null) return dp[idxs][idxt];
		int sum = 0;
		if (s[idxs] == t[idxt]) {
			sum += dfs(s, t, idxs + 1, idxt, dp) + dfs(s, t, idxs + 1, idxt + 1, dp);
		} else {
			sum += dfs(s, t, idxs + 1, idxt, dp);
		}
		dp[idxs][idxt] = sum;
		return sum;
	}
}
