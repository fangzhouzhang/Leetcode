public class _1504 {
	public int findAllOneMat(int[][] mat) {
		if (mat == null || mat.length == 0 || mat[0].length == 0) return 0;
		int rows = mat.length, cols = mat[0].length;
		int[][] dp = new int[rows][cols];
		for (int i = 0; i < rows; i++) {
			dp[i][cols - 1] = mat[i][cols - 1];
		}
		for (int i = 0; i < rows; i++) {
			for (int j = cols - 2; j >= 0; j--) {
				if (mat[i][j] == 1) {
					dp[i][j] = dp[i][j + 1] + 1;
				} else {
					dp[i][j] = 0;
				}
			}
		}
		int res = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (mat[i][j] == 0) continue;
				for (int k = i; k < rows; k++) {
					int min = Integer.MAX_VALUE;
					min = Math.min(min, dp[k][j]);
					if (min == 0) break;
					res += min;
				}
			}
		}
		return res;
	}
}
