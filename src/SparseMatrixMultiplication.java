public class SparseMatrixMultiplication {
	public int[][] multiply(int[][] A, int[][] B) {
		int aRow = A.length;
		int aCol = A[0].length;
		int bCol = B[0].length;
		int[][] C = new int[aRow][bCol];
		for (int i = 0; i < aRow; i++) {
			for (int k = 0; k < aCol; k++) {
				if (A[i][k] != 0) {
					for (int j = 0; j < bCol; j++) {
						if (B[k][j] != 0) {
							C[i][j] += A[i][k] * B[k][j];
						}
					}
				}
			}
		}
		return C;
	}
}
