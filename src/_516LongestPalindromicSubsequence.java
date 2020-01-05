public class _516LongestPalindromicSubsequence {
	public int longestPalindromeSubseq(String s) {
		if (s.length() == 0) {
			return 0;
		}
		int[] dp = new int[s.length()];
		int n = s.length();
		for (int i = n - 1; i >= 0; i--) {
			int lb = 0;//left_bottom_corner value
			dp[i] = 1;
			for (int j = i + 1; j < n; j++) {
				int cur;
				if (s.charAt(i) == s.charAt(j)) {
					cur = 2 + lb;
				} else {
					cur = Math.max(dp[j - 1], dp[j]);
				}
				lb = dp[j];
				dp[j] = cur;
			}
		}
		return dp[n - 1];
	}

	public int longestPalindromeSubseqMyIterative(String s) {
		if (s == null || s.length() == 0) return 0;
		int[][] dp = new int[s.length()][s.length()];
		char[] a = s.toCharArray();
		for (int distance = 0; distance < s.length(); distance++) {
			for (int i = 0; i + distance < s.length(); i++) {
				if (distance == 0) dp[i][i + distance] = 1;
				else if (distance == 1) {
					dp[i][i + 1] = a[i] == a[i + 1] ? 2 : 1;
				} else dp[i][i + distance] = a[i] == a[i + distance] ? 2 + dp[i + 1][i + distance - 1] : Math.max(dp[i + 1][i + distance], dp[i][i + distance - 1]);
			}
		}
		return dp[0][s.length() - 1];
	}

	public int longestPalindromeSubseqDfsMemo(String s) {
		if (s == null || s.length() == 0) return 0;
		Integer[][] dp = new Integer[s.length()][s.length()];
		return dfs(s.toCharArray(), 0, s.length() - 1, dp);
	}

	private int dfs(char[] a, int start, int end, Integer[][] dp) {
		if (start == end) return 1;
		if (start > end) return 0;
		if (dp[start][end] != null) return dp[start][end];
		int max = 0;
		if (a[start] == a[end]) max = Math.max(max, dfs(a, start + 1, end - 1, dp) + 2);
		else max = Math.max(max, Math.max(dfs(a, start, end - 1, dp), dfs(a, start + 1, end, dp)));
		dp[start][end] = max;
		return max;
	}
}
