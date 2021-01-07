public class _74Searcha2DMatrix {
	int R = 0;
	int C = 0;
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0) return false;
		R = matrix.length;
		if (matrix[0].length == 0) return false;
		C = matrix[0].length;
		int l = 0, r = R * C - 1;
		while (l < r) {
			int mid = l + r + 1 >> 1;
			if (matrix[mid / C][mid % C] > target) r = mid - 1;
			else l = mid;
		}
		return matrix[l / C][l % C] == target;
	}

	public boolean searchMatrixI(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0) return false;
		R = matrix.length;
		if (matrix[0].length == 0) return false;
		C = matrix[0].length;
		int l = 0, r = R * C - 1;
		while (l < r) {
			int mid = l + r >> 1;
			if (matrix[mid / C][mid % C] >= target) r = mid;
			else l = mid + 1;
		}
		return matrix[l / C][l % C] == target;
	}
}
