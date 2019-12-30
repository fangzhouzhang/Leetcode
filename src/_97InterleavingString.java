public class _97InterleavingString {
	public boolean isInterleaveDFS(String s1, String s2, String s3) {
		if (s1 == null || s2 == null || s3 == null) return false;
		char[] a1 = s1.toCharArray();
		char[] a2 = s2.toCharArray();
		char[] a3 = s3.toCharArray();
		if (a1.length + a2.length != a3.length) return false;
		Boolean[][] dp = new Boolean[a1.length + 1][a2.length + 1];
		return dfs(a1, 0, a2, 0, a3, 0, dp);
	}

	private boolean dfs(char[] a1, int idx1, char[] a2, int idx2, char[] a3, int idx3, Boolean[][] dp) {
		if (a3.length == idx3) return true;
		if (dp[idx1][idx2] != null) return dp[idx1][idx2];
		if ((idx1 < a1.length && a1[idx1] == a3[idx3] && dfs(a1, idx1 + 1, a2, idx2, a3, idx3 + 1, dp)) ||
				(idx2 < a2.length && a2[idx2] == a3[idx3] && dfs(a1, idx1, a2, idx2 + 1, a3, idx3 + 1, dp))) {
			dp[idx1][idx2] = true;
			return true;
		}
		dp[idx1][idx2] = false;
		return false;
	}
}
