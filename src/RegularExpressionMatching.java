public class RegularExpressionMatching {
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
		dfs(s, 0, p, 0, dp);
		return dp[0][0];
	}
	private boolean dfs(String s, int idxs, String p, int idxp, Boolean[][] dp) {
		if (idxp == p.length()) {
			boolean val = idxs == s.length();
			dp[idxs][idxp] = val;
			return val;
		}
		if (dp[idxs][idxp] != null) {
			return dp[idxs][idxp];
		}
		if (idxp == p.length() - 1 || p.charAt(idxp + 1) != '*') {
			//letter or '.'
			if (idxs < s.length() && (p.charAt(idxp) == '.' || p.charAt(idxp) == s.charAt(idxs))) {
				boolean val = dfs(s, idxs + 1, p, idxp + 1, dp);
				dp[idxs][idxp] = val;
				return val;
			} else {
				boolean val = false;
				dp[idxs][idxp] = val;
				return val;
			}
		} else {
			int i = idxs - 1;
			while (i < s.length() && (i == idxs - 1 || p.charAt(idxp) == '.' || p.charAt(idxp) == s.charAt(i))) {
				if (dfs(s, i + 1, p, idxp + 2, dp)) {
					dp[idxs][idxp] = true;
					return true;
				} else {
					i++;
				}
			}
			dp[idxs][idxp] = false;
			return false;
		}
	}
}
