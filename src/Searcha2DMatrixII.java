public class Searcha2DMatrixII {
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}
		if (matrix[0][0] > target || matrix[matrix.length - 1][matrix[0].length - 1] < target) {
			return false;
		}
		int i = matrix.length - 1;
		int j = 0;
		while (true) {
			if (matrix[i][j] < target) {
				j++;
				// System.out.println("j " + j);
			} else if (matrix[i][j] > target) {
				i--;
				// System.out.println("i " + i);
			} else {
				return true;
			}
			if (i < 0 || j >= matrix[0].length) {
				break;
			}
		}
		return false;
	}
}
