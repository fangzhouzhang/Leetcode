public class _1745PalindromePartitioningIV {
	int n = 0;
	boolean[][] table;
	public boolean checkPartitioning(String s) {
		if (s == null || s.length() == 0) return false;
		this.n = s.length();
		table = new boolean[n][n];
		for (int len = 1; len < n; len++) {
			for (int i = 0; i + len - 1 < n; i++) {
				if (len == 1) table[i][i + len - 1] = true;
				else if (len == 2) {
					table[i][i + len - 1] = s.charAt(i) == s.charAt(i + len - 1);
				} else {
					table[i][i + len - 1] = (s.charAt(i) == s.charAt(i + len - 1)) && table[i + 1][i + len - 2];
				}
			}
		}
		Boolean[][] dp = new Boolean[n][4];
		return dfs(s, 0, 3, dp);
	}

	private boolean dfs(String s, int idx, int remain, Boolean[][] dp) {
		if (idx == s.length()) {
			if (remain == 0) return true;
			else return false;
		}
		if (remain == 0) return false;
		if (dp[idx][remain] != null) return dp[idx][remain];
		for (int end = n - 1; end >= idx; end--) {
			boolean palin = true;
			if (table[idx][end]) {
				if (dfs(s, end + 1, remain - 1, dp)) {
					return dp[idx][remain] = true;
				}
			}
		}
		return dp[idx][remain] = false;
	}

	public boolean checkPartitioningI(String s) {
		if (s == null || s.length() == 0) return false;
		this.n = s.length();
		table = new boolean[n][n];
		for (int len = 1; len < n; len++) {
			for (int i = 0; i + len - 1 < n; i++) {
				if (len == 1) table[i][i + len - 1] = true;
				else if (len == 2) {
					table[i][i + len - 1] = s.charAt(i) == s.charAt(i + len - 1);
				} else {
					table[i][i + len - 1] = (s.charAt(i) == s.charAt(i + len - 1)) && table[i + 1][i + len - 2];
				}
			}
		}
		for (int i = 1; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (table[0][i - 1] && table[i][j - 1] && table[j][n - 1]) return true;
			}
		}
		return false;
	}
}
