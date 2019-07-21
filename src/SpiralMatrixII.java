public class SpiralMatrixII {
	public int[][] generateMatrix(int n) {
		if (n == 0) {
			return new int[0][0];
		}
		int rowStart = 0;
		int rowEnd = n - 1;
		int colStart = 0;
		int colEnd = n - 1;
		int num = 1;
		int[][] m = new int[n][n];
		while (num <= n * n) {
			for (int i = colStart; i <= colEnd; i++, num++) {
				m[rowStart][i] = num;
			}
			rowStart++;

			for (int i = rowStart; i <= rowEnd; i++, num++) {
				m[i][colEnd] = num;
			}
			colEnd--;

			for (int i = colEnd; i >= colStart; i--, num++) {
				m[rowEnd][i] = num;
			}
			rowEnd--;

			for (int i = rowEnd; i >= rowStart; i--, num++) {
				m[i][colStart] = num;
			}
			colStart++;
		}
		return m;
	}
}
