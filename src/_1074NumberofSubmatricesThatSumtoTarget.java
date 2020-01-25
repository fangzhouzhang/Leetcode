public class _1074NumberofSubmatricesThatSumtoTarget {
	public int numSubmatrixSumTarget(int[][] matrix, int target) {
		//prefix sum for each row and col
		if (matrix == null || matrix.length == 0) return 0;
		int row = matrix.length, col = matrix[0].length;
		int[][] prefix = new int[row][col + 1];
		for (int i = 0; i < row; i++) {
			int sum = 0;
			for (int j = 0; j < col; j++) {
				sum += matrix[i][j];
				prefix[i][j + 1] = sum;
			}
		}
		int res = 0;
		//traverse all arrays and once meeting arr sum == target, res++
		int[] colPrefix = new int[row + 1];


		for (int j = 0; j < col; j++) {
			for (int m = j + 1; m < col + 1; m++) {
				int sum = 0;
				for (int i = 0; i < row; i++) {
					sum += prefix[i][m] - prefix[i][j];
					colPrefix[i + 1] = sum;
					// System.out.print(colPrefix[i + 1] + " ");
				}
				// System.out.println();
				res += searchTarget(colPrefix, target);
			}
		}
		return res;
	}

	private int searchTarget(int[] colPrefix, int target) {
		int res = 0;
		for (int i = 0; i < colPrefix.length - 1; i++) {
			for (int j = i + 1; j < colPrefix.length; j++) {
				if (colPrefix[j] - colPrefix[i] == target) res++;
			}
		}
		return res;
	}
}
