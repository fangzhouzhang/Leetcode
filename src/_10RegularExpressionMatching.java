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
		Boolean[][] dp = new Boolean[s.length() + 1][p.length() + 1];
		return dfs(s, 0, p, 0, dp);
	}

	private boolean dfs(String s, int idxs, String p, int idxp, Boolean[][] dp) {
		// idxs == s.length() could we judge true or false?
		// "a", "az*"
		if (idxp == p.length()) {
			return idxs == s.length();
		}
		if (dp[idxs][idxp] != null) return dp[idxs][idxp];

		if (idxp + 1 == p.length() || (idxp + 1 < p.length() && p.charAt(idxp + 1) != '*')) {
			if (idxs < s.length() && (s.charAt(idxs) == p.charAt(idxp) || p.charAt(idxp) == '.')) {
				return dp[idxs][idxp] = dfs(s, idxs + 1, p, idxp + 1, dp);
			} else {
				return dp[idxs][idxp] = false;
			}
		} else {
			int i = idxs - 1;
			while (i < s.length() && (i == idxs - 1 || p.charAt(idxp) == '.' || p.charAt(idxp) == s.charAt(i))) {
				if (dfs(s, i + 1, p, idxp + 2, dp)) {
					return dp[idxs][idxp] = true;
				} else {
					i++;
				}
			}
			return dp[idxs][idxp] = false;
		}
	}
}
