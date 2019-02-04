public class InterleavingString {
	public boolean isInterleave(String s1, String s2, String s3) {
		if (s1.length() + s2.length() != s3.length()) {
			return false;
		}

		boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];

		dp[0][0] = true;
		for (int row = 1; row < dp.length; row++) {
			if (dp[row - 1][0] == true && s1.charAt(row - 1) == s3.charAt(row - 1)) {
				dp[row][0] = true;
			} else {
				dp[row][0] = false;
			}

		}
		for (int col = 1; col < dp[0].length; col++) {
			if (dp[0][col - 1] == true && s2.charAt(col - 1) == s3.charAt(col - 1)) {
				dp[0][col] = true;
			} else {
				dp[0][col] = false;
			}
		}
		for (int row = 1; row < dp.length; row++) {
			for (int col = 1; col < dp[row].length; col++) {
				if (dp[row][col - 1] == true && s2.charAt(col - 1) == s3.charAt(row + col - 1)) {
					dp[row][col] = true;
				} else if (dp[row - 1][col] == true && s1.charAt(row - 1) == s3.charAt(row + col - 1)) {
					dp[row][col] = true;
				} else {
					dp[row][col] = false;
				}
			}
		}
		return dp[dp.length - 1][dp[0].length - 1];
	}
}
