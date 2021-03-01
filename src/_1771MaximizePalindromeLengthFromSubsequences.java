public class _1771MaximizePalindromeLengthFromSubsequences {
	public int longestPalindrome(String word1, String word2) {
		if (word1 == null || word2 == null) return 0;
		StringBuilder sb = new StringBuilder();
		sb.append(word2);
		word2 = new String(sb.reverse());
		int n = word1.length(), m = word2.length();
		int[][] subse = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (word1.charAt(i - 1) == word2.charAt(j - 1)) subse[i][j] = subse[i - 1][j - 1] + 1;
				else subse[i][j] = Math.max(subse[i - 1][j], subse[i][j - 1]);
			}
		}
		int[][] p1 = new int[n][n];
		for (int len = 1; len <= n; len++) {
			for (int start = 0; start + len - 1 < n; start++) {
				if (len == 1) {
					p1[start][start + len - 1] = 1;
				} else {
					p1[start][start + len - 1] = word1.charAt(start) == word1.charAt(start + len - 1) ? 2 + p1[start + 1][start + len - 2] : Math.max(p1[start][start + len - 2], p1[start + 1][start + len - 1]);
				}
			}
		}

		int[][] p2 = new int[m][m];
		for (int len = 1; len <= m; len++) {
			for (int start = 0; start + len - 1 < m; start++) {
				if (len == 1) {
					p2[start][start + len - 1] = 1;
				} else {
					p2[start][start + len - 1] = word2.charAt(start) == word2.charAt(start + len - 1) ? 2 + p2[start + 1][start + len - 2] : Math.max(p2[start][start + len - 2], p2[start + 1][start + len - 1]);
				}
			}
		}

		int res = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int panlinMax = 0;
				if (i != n - 1) {
					panlinMax = Math.max(p1[i + 1][n - 1], panlinMax);
				}
				if (j != m - 1) {
					panlinMax = Math.max(p2[j + 1][m - 1], panlinMax);
				}
				if (subse[i + 1][j + 1] > 0)
					res = Math.max(res, subse[i + 1][j + 1]  * 2 + panlinMax);
			}
		}
		return res;
	}
}
