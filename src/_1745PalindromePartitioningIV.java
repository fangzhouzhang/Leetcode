public class _1745PalindromePartitioningIV {
	int n = 0;
	public boolean checkPartitioning(String s) {
		if (s == null || s.length() == 0) return false;
		this.n = s.length();
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
			for (int l = idx, r = end; l < r; l++, r--) {
				if (s.charAt(l) != s.charAt(r)) {
					palin = false;
					break;
				}
			}
			if (palin) {
				if (dfs(s, end + 1, remain - 1, dp)) {
					return dp[idx][remain] = true;
				}
			}
		}
		return dp[idx][remain] = false;
	}
}
