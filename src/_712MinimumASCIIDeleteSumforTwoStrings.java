public class _712MinimumASCIIDeleteSumforTwoStrings {
	public int minimumDeleteSum(String s1, String s2) {
		Integer[][] dp = new Integer[s1.length()][s2.length()];
		return dfs(s1, 0, s2, 0, dp);
	}

	private int dfs(String a, int i, String b, int j, Integer[][] dp) {
		if (i == a.length() && j == b.length()) return 0;
		if (i == a.length()) {
			int res = 0;
			for (int k = j; k < b.length(); k++) {
				res += b.charAt(k);
			}
			return res;
		}
		if (j == b.length()) {
			int res = 0;
			for (int k = i; k < a.length(); k++) {
				res += a.charAt(k);
			}
			return res;
		}
		if (dp[i][j] != null) return dp[i][j];
		int res = Integer.MAX_VALUE;
		if (a.charAt(i) == b.charAt(j)) {
			return dfs(a, i + 1, b, j + 1, dp);
		} else {
			res = Math.min(dfs(a, i + 1, b, j, dp) + a.charAt(i), dfs(a, i, b, j + 1, dp) + b.charAt(j));
			return dp[i][j] = res;
		}
	}
}
