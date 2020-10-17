public class _48RotateImage {
	public void rotate(int[][] matrix) {
		if (matrix == null || matrix.length == 0) return;
		int n = matrix.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = tmp;
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0, k = n - 1; j < k; j++, k--) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[i][k];
				matrix[i][k] = tmp;
			}
		}
	}

	private void swap(int[] a, int b, int c) {
		int tmp = a[b];
		a[b] = a[c];
		a[c] = tmp;
	}
}
