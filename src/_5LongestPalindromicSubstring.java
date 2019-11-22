public class _5LongestPalindromicSubstring {
	/**
	 * time: o(n^2) space: o(n^2)
	 * @param s
	 * @return
	 */
	public String longestPalindrome(String s) {
		if (s == null || s.length() == 0) return s;
		int start = 0, end = 0;
		int max = -1;
		boolean[][] dp = new boolean[s.length()][s.length()];
		for (int delta = 0; delta < s.length(); delta++) {
			for (int i = 0; i + delta < s.length(); i++) {
				if (delta == 0) dp[i][i + delta] = true;
				else if (delta == 1) dp[i][i + delta] = s.charAt(i) == s.charAt(i + delta);
				else {
					if (s.charAt(i) == s.charAt(i + delta)) {
						dp[i][i + delta] = dp[i + 1][i + delta - 1];
					} else {
						dp[i][i + delta] = false;
					}
				}
				if (dp[i][i + delta] && max < delta + 1) {
					max = delta + 1;
					start = i;
					end = i + delta;
				}
			}
		}
		return s.substring(start, end + 1);
	}
}
