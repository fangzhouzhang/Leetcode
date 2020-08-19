public class _1292MaximumSideLengthofaSquarewithSumLessthanorEqualtoThreshold {
	public int maxSideLength(int[][] mat, int threshold) {
		if (mat == null || mat.length == 0 || mat[0].length == 0) return 0;
		int rows = mat.length, cols = mat[0].length;
		int len = Math.min(rows, cols);
		int[][] prefix = getPrefix(mat, rows, cols);
		int start = 1, end = len;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (valid(mid, prefix, rows, cols, threshold)) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		if (end <= threshold) return end;
		return 0;
	}

	private int[][] getPrefix(int[][] mat, int rows, int cols) {
		int[][] prefix = new int[rows + 1][cols + 1];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				prefix[i + 1][j + 1] = prefix[i][j + 1] + prefix[i + 1][j] + mat[i][j] - prefix[i][j];
			}
		}
		return prefix;
	}

	private boolean valid(int len, int[][] prefix, int rows, int cols, int  threshold) {
		for (int i = 0; i + len < rows + 1; i++) {
			for (int j = 0; j + len < cols + 1; j++) {
				if (prefix[i][j] + prefix[i + len][j + len] - prefix[i][j + len] - prefix[i + len][j] <= threshold) return true;
			}
		}
		return false;
	}
}
