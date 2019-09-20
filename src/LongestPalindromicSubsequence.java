public class LongestPalindromicSubsequence {
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
}
