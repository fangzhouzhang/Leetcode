public class EditDistance {
    /**
     * @param word1: A string
     * @param word2: A string
     * @return: The minimum number of steps.
     * Time : O(n^2) Space : O(n^2)
     */
    public int minDistance(String word1, String word2) {
        // write your code here
        int row = word1.length();
        int col = word2.length();
        int[][] m = new int[row + 1][col + 1];
        for (int i = 0; i < row + 1; i++) {
            //m[0][i] = i;
            m[i][0] = i;
        }
        for (int i = 0; i < col + 1; i++) {
            m[0][i] = i;
            // m[i][0] = i;
        }
        for (int i = 1; i < row + 1; i++) {
            for (int j = 1; j < col + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    m[i][j] = m[i - 1][j - 1];
                    continue;
                }
                int min = Integer.MAX_VALUE;
                min = Math.min(m[i - 1][j - 1], Math.min(m[i][j - 1], m[i - 1][j]));
                m[i][j] = 1 + min;
            }
        }
        return m[row][col];
    }
	public int minDistance1(String word1, String word2) {
		if (word1.length() == 0) {
			return word2.length();
		}
		if (word2.length() == 0) {
			return word1.length();
		}
		if (word1.equals(word2)) {
			return 0;
		}
		int[][] dp = new int[word1.length() + 1][word2.length() + 1];
		//Integer[][] dp = new Integer[word1.length() + 1][word2.length() + 1];

		dp[word1.length()][word2.length()] = 0;

		for (int i = 0; i < word2.length() + 1; i++) {
			dp[word1.length()][i] = word2.length() - i;
		}

		for (int i = 0; i < word1.length() + 1; i++) {
			dp[i][word2.length()] = word1.length() - i;
		}

		for (int i = word1.length() - 1; i >= 0; i--) {
			for (int j = word2.length() - 1; j >= 0; j--) {
				if (word1.charAt(i) == word2.charAt(j)) {
					dp[i][j] = dp[i + 1][j + 1];
				} else {
					int min = Integer.MAX_VALUE;
					min = Math.min(min, dp[i + 1][j + 1]);
					min = Math.min(min, dp[i][j + 1]);
					min = Math.min(min, dp[i + 1][j]);
					dp[i][j] = min + 1;
				}
			}
		}
		return dp[0][0];
		//return dfs(word1, 0, word2, 0, dp);
	}
	private int dfs(String word1, int idx1, String word2, int idx2, Integer[][] dp) {
		if (idx1 == word1.length() && idx2 == word2.length()) {
			dp[idx1][idx2] = 0;
			return 0;
		}
		if (idx1 == word1.length()) {
			dp[idx1][idx2] = word2.length() - idx2;
			return word2.length() - idx2;
		}
		if (idx2 == word2.length()) {
			dp[idx1][idx2] = word1.length() - idx1;
			return word1.length() - idx1;
		}
		if (dp[idx1][idx2] != null) {
			return dp[idx1][idx2];
		}

		char c1 = word1.charAt(idx1);
		char c2 = word2.charAt(idx2);

		if (c1 == c2) {
			return dfs(word1, idx1 + 1, word2, idx2 + 1, dp);
		}

		//c1 != c2


		int min = Integer.MAX_VALUE;
		int v1 = dfs(word1, idx1 + 1, word2, idx2 + 1, dp);
		int v2 = dfs(word1, idx1, word2, idx2 + 1, dp);
		int v3 = dfs(word1, idx1 + 1, word2, idx2, dp);

		min = Math.min(min, v1);
		min = Math.min(min, v2);
		min = Math.min(min, v3);

		dp[idx1][idx2] = min + 1;
		return dp[idx1][idx2];

	}
}
