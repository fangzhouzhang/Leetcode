public class _240Searcha2DMatrixII {
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
		int rows = matrix.length, cols = matrix[0].length;
		int r = 0, c = cols - 1;
		while (r < rows && c >= 0) {
			if (matrix[r][c] == target) return true;
			else if (matrix[r][c] > target) {
				c--;
			} else {
				r++;
			}
		}
		return false;
	}
}
