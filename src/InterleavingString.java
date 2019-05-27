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

	public boolean isInterleaveDFS(String s1, String s2, String s3) {
		if (s1.length() == 0 && s2.length() == 0 && s3.length() == 0 ) {
			return true;
		}
		if (s1.length() + s2.length() != s3.length()) {
			return false;
		}
		Boolean[][] mem = new Boolean[s1.length()][s2.length()];
		return dfs(s1, 0, s2, 0, s3, 0, mem);

	}
	private boolean dfs(String s1, int idx1, String s2, int idx2, String s3, int idx3, Boolean[][] mem) {
		if (idx3 == s3.length()) {
			return (idx1 == s1.length() && idx2 == s2.length());
		}

		if (idx3 < s3.length() && (idx1 >= s1.length() && idx2 >= s2.length())) {
			return false;
		}
		if (idx1 == s1.length()) {
			return s2.substring(idx2).equals(s3.substring(idx3));
		}
		if (idx2 == s2.length()) {
			return s1.substring(idx1).equals(s3.substring(idx3));
		}

		if (mem[idx1][idx2] != null) {
			return mem[idx1][idx2];
		}

		Boolean ret1 = false;
		if (s1.charAt(idx1) == s3.charAt(idx3)) {
			ret1 = dfs(s1, idx1 + 1, s2, idx2, s3, idx3 + 1, mem);
		}

		Boolean ret2 = false;
		if (s2.charAt(idx2) == s3.charAt(idx3)) {
			ret2 = dfs(s1, idx1, s2, idx2 + 1, s3, idx3 + 1, mem);
		}

		if (ret1 == true || ret2 == true) {
			mem[idx1][idx2] = true;
			return true;
		} else {
			mem[idx1][idx2] = false;
			return false;
		}



	}
}
