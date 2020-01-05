public class _5306MinimumInsertionStepstoMakeaStringPalindrome {
	public int minInsertions(String s) {
		if (s == null || s.length() == 0) return 0;
		Integer[][] dp = new Integer[s.length()][s.length()];
		return dfs(s.toCharArray(), 0, s.length() - 1, dp);
	}

	private int dfs(char[] a, int start, int end, Integer[][] dp) {
		if (start >= end) return 0;
		if (dp[start][end] != null) return dp[start][end];
		int min = Integer.MAX_VALUE;
		if (a[start] == a[end]) min = Math.min(min, dfs(a, start + 1, end - 1, dp));
		else min = Math.min(Math.min(dfs(a, start + 1, end, dp) + 1, dfs(a, start, end - 1, dp) + 1), min);
		dp[start][end] = min;
		return min;
	}
}
