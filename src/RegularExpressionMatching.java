public class _10RegularExpressionMatching {
	/**
	 * time: o(n * m) space: o(n * m)
	 * @param s
	 * @param p
	 * @return
	 */
	public boolean isMatch(String s, String p) {
		boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
		dp[0][0] = true;
		for (int i = 0; i < p.length(); i++) {
			if (p.charAt(i) == '*' && dp[0][i - 2 + 1] == true) {
				dp[0][i + 1] = true;
			}
		}
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < p.length(); j++) {
				if (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.') {
					dp[i + 1][j + 1] = dp[i][j];
				} else if (p.charAt(j) == '*') {
					if (p.charAt(j - 1) == s.charAt(i) || p.charAt(j - 1) == '.') {
						dp[i + 1][j + 1] = (dp[i + 1][j]|| dp[i][j + 1] || dp[i + 1][j - 1]);
					} else {
						dp[i + 1][j + 1] = dp[i + 1][j - 2 + 1];
					}
				}
			}
		}
		return dp[s.length()][p.length()];
	}
	
	public boolean isMatch2(String s, String p) {
		if (s == null || p == null) return false;
		Boolean[][] dp = new Boolean[s.length() + 1][p.length() + 1];
		return dfs(s, 0, p, 0, dp);
	}

	private boolean dfs(String s, int idxs, String p, int idxp, Boolean[][] dp) {
		if (p.length() == idxp) {
			return idxs == s.length();
		}

		if (dp[idxs][idxp] != null) return dp[idxs][idxp];
		boolean res;
		boolean firstMatch = (idxs < s.length()) && ((s.charAt(idxs) == p.charAt(idxp)) || p.charAt(idxp) == '.');
		if (idxp + 1 < p.length() && p.charAt(idxp + 1) == '*') {
			res = dfs(s, idxs, p, idxp + 2, dp) || (firstMatch && dfs(s, idxs + 1, p, idxp, dp));
		} else {
			res = firstMatch && dfs(s, idxs + 1, p, idxp + 1, dp);
		}
		dp[idxs][idxp] = res;
		return res;
	}
}
