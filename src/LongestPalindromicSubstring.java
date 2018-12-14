public class LongestPalindromicSubstring {
	/**
	 * time: o(n^2) space: o(n^2)
	 * @param s
	 * @return
	 */
	public String longestPalindrome(String s) {
		if (s.length() <= 1) {
			return s;
		}
		int slow = 0;
		int fast = 0;
		int max = 0;
		boolean[][] dp = new boolean[s.length()][s.length()];
		for (int offset = 0; offset < s.length(); offset++) {
			for (int start = 0; start < s.length() - offset; start++) {
				if (offset == 0) {
					dp[start][start + offset] = true;
				} else if (offset == 1) {
					dp[start][start + offset] = s.charAt(start) == s.charAt(start + offset);
				} else {
					dp[start][start + offset] = (s.charAt(start) == s.charAt(start + offset)) &&
							(dp[start + 1][start + offset - 1]);
				}
				//System.out.println(" start " + start + " offset " + offset + " value: " + dp[start][start + offset]);
				if (dp[start][start + offset] == true && offset + 1 > max) {
					slow = start;
					fast = start + offset;
					max = offset + 1;
				}
			}
		}
		return s.substring(slow, fast + 1);
	}
}
