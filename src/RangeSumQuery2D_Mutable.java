public class RangeSumQuery2D_Mutable {
	private int[][] tree;
	private int[][] nums;
	private int m;
	private int n;
	public RangeSumQuery2D_Mutable(int[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0) {
			return;
		}
		m = matrix.length;
		n = matrix[0].length;

		tree = new int[m + 1][n + 1];
		nums = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				update(i, j, matrix[i][j]);
			}
		}
	}

	public void update(int row, int col, int val) {
		if (m == 0 || n == 0) {
			return;
		}
		int diff = val - nums[row][col];
		nums[row][col] = val;
		for (int i = row + 1; i < tree.length; i += (i & (-i))) {
			for (int j = col + 1; j < tree[i].length; j += (j & (-j))) {
				tree[i][j] += diff;
			}
		}
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		if (m == 0 || n == 0) {
			return 0;
		}
		return getSum(row2 + 1, col2 + 1) + getSum(row1, col1) - getSum(row1, col2 + 1) - getSum(row2 + 1, col1);
	}

	private int getSum(int row, int col) {
		if (m == 0 || n == 0) {
			return 0;
		}
		int sum = 0;
		for (int i = row; i > 0; i -= (i & (-i))) {
			for (int j = col; j > 0; j -= (j & (-j))) {
				sum += tree[i][j];
			}
		}
		return sum;
	}
}
