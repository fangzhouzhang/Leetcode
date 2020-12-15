public class _1641CountSortedVowelStrings {
	public int countVowelStrings(int n) {
		long[][] dp = new long[n + 1][6];
		if (n == 0) return 0;
		if (n == 1) return 5;
		if (n == 2) return 15;
		dp[2][0] = 5;
		dp[2][1] = 4;
		dp[2][2] = 3;
		dp[2][3] = 2;
		dp[2][4] = 1;
		dp[2][5] = 15;
		for (int i = 3; i <= n; i++) {
			dp[i][0] = dp[i - 1][5];
			dp[i][1] = dp[i - 1][5] - dp[i - 1][0];
			dp[i][2] = dp[i - 1][5] - dp[i - 1][0] - dp[i - 1][1];
			dp[i][3] = dp[i - 1][5] - dp[i - 1][0] - dp[i - 1][1] - dp[i - 1][2];
			dp[i][4] = dp[i - 1][5] - dp[i - 1][0] - dp[i - 1][1] - dp[i - 1][2] - dp[i - 1][3];
			dp[i][5] = dp[i][0] + dp[i][1] + dp[i][2] + dp[i][3] + dp[i][4];
		}
		return (int)dp[n][5];
	}
}
