public class _221MaximalSquare {
    /**
     * @param matrix: a matrix of 0 and 1
     * @return: an integer
     * Time : O(n^2) Space : O(n^2)
     */
	public int maximalSquare(char[][] matrix) {
		if (matrix == null || matrix.length == 0) return 0;
		int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
		int len = 0;
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[i].length; j++) {
				if (matrix[i - 1][j - 1] == '1') dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1],dp[i - 1][j])) + 1;
				len = Math.max(len, dp[i][j]);
			}
		}
		return len * len;
	}
}
