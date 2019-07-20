public class Searcha2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}
		int col = matrix[0].length;
		int row = matrix.length;
		int len = row * col;
		return binarySearch(matrix, target, row, col);
	}

	private boolean binarySearch(int[][] matrix, int target, int row, int col) {
		int start = 0;
		int end = row * col - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			int r = mid / col;
			int c = mid % col;
			if (matrix[r][c] == target) {
				return true;
			} else if (matrix[r][c] < target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return false;
	}
}
