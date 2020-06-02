public class _221MaximalSquare {
    /**
     * @param matrix: a matrix of 0 and 1
     * @return: an integer
     * Time : O(n^2) Space : O(n^2)
     */
	public int maximalSquare(char[][] matrix) {
		if (matrix == null || matrix.length == 0) return 0;
		int n = matrix.length;
		int m = matrix[0].length;
		int[][] dp = new int[n][m];
		int res = 0;
		for (int i = 0; i < n; i++) {
			dp[i][0] = matrix[i][0] - '0';
			res = Math.max(res, dp[i][0]);
		}
		for (int i = 0; i < m; i++) {
			dp[0][i] = matrix[0][i] - '0';
			res = Math.max(res, dp[0][i]);
		}
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				if (matrix[i][j] == '0') dp[i][j] = 0;
				else {
					dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
				}
				res = Math.max(res, dp[i][j]);
			}
		}
		return res * res;
	}
}
