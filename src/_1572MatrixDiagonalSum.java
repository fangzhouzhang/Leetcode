public class _1572MatrixDiagonalSum {
	public int diagonalSum(int[][] mat) {
		int n = mat.length;
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += mat[i][i];
		}
		for (int i = 0, j = n - 1; i < n && j >= 0; i++,j--) {
			sum += mat[i][j];
		}
		if (n % 2 == 1) {
			sum -= mat[n / 2][n / 2];
		}
		return sum;
	}
}
