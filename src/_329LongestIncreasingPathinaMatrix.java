public class _329LongestIncreasingPathinaMatrix {
	private int[][] dirs = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
	public int longestIncreasingPath(int[][] matrix) {
		if (matrix == null || matrix.length == 0) return 0;
		Integer[][] dp = new Integer[matrix.length][matrix[0].length];
		int max = 1;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				max = Math.max(max, dfs(matrix, i, j, dp));
			}
		}
		return max;
	}

	private int dfs(int[][] matrix, int row, int col, Integer[][] dp) {
		if (dp[row][col] != null) return dp[row][col];
		int max = 1;
		for (int[] dir : dirs) {
			int newRow = row + dir[0];
			int newCol = col + dir[1];
			if (isValid(matrix, newRow, newCol) && matrix[row][col] < matrix[newRow][newCol]) max = Math.max(max, dfs(matrix, newRow, newCol, dp) + 1);
		}
		dp[row][col] = max;
		return max;
	}

	private boolean isValid(int[][] matrix, int row, int col) {
		if (row < 0 || row >= matrix.length) return false;
		if (col < 0 || col >= matrix[row].length) return false;
		return true;
	}
}
