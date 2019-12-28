public class _363MaxSumofRectangleNoLargerThanK {
	public int maxSumSubmatrix(int[][] matrix, int k) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
		int n = matrix.length;
		int m = matrix[0].length;
		int[][] prefix = new int[n][m + 1];
		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int j = 1; j < m + 1; j++) {
				sum += matrix[i][j - 1];
				prefix[i][j] = sum;
				if (sum == k) return k;
			}
		}
		int closest = matrix[0][0];
		for (int j = 0; j < m; j++) {
			for (int p = j + 1; p < m + 1; p++) {
				int[] arr = new int[n];
				for (int i = 0; i < n; i++) arr[i] = prefix[i][p] - prefix[i][j];
				for (int i = 0; i < n; i++) {
					int sum = 0;
					for (int l = i; l < n; l++) {
						sum += arr[l];
						if (sum == k) return k;
						if (sum < k && Math.abs(sum - k) < Math.abs(closest - k)) closest = sum;
					}
				}
			}
		}
		return closest;
	}
}
