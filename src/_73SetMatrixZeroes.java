public class _73SetMatrixZeroes {
	public void setZeroes(int[][] matrix) {
		if (null == matrix || matrix.length == 0 || matrix[0].length == 0) return;
		int n = matrix.length, m = matrix[0].length;
		boolean r0 = false, c0 = false;
		for (int i = 0; i < n; i++) {
			if (matrix[i][0] == 0) {
				c0 = true;
				break;
			}
		}
		for (int i = 0; i < m; i++) {
			if (matrix[0][i] == 0) {
				r0 = true;
				break;
			}
		}

		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}

		for (int i = 1; i < n; i++) {
			if (matrix[i][0] == 0) {
				for (int j = 0; j < m; j++) {
					matrix[i][j] = 0;
				}
			}
		}
		for (int j = 1; j < m; j++) {
			if (matrix[0][j] == 0) {
				for (int i = 0; i < n; i++) {
					matrix[i][j] = 0;
				}
			}
		}

		if (r0) {
			for (int j = 0; j < m; j++) {
				matrix[0][j] = 0;
			}
		}
		if (c0) {
			for (int i = 0; i < n; i++) {
				matrix[i][0] = 0;
			}
		}

	}
}
