public class _308RangeSumQuery2D_Mutable {
	private class NumMatrix {
		int[][] tree;
		int[][] nums;
		int m;
		int n;
		public NumMatrix(int[][] matrix) {
			if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
			this.nums = matrix;
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
			int diff = val - nums[row][col];
			for (int i = row + 1; i < tree.length; i += (i & -i)) {
				for (int j = col + 1; j < tree[i].length; j += (j & -j)) {
					tree[i][j] += diff;
				}
			}

			nums[row][col] = val;
		}

		public int sumRegion(int row1, int col1, int row2, int col2) {
			return getSum(row2 + 1, col2 + 1) + getSum(row1, col1) - getSum(row1, col2 + 1) - getSum(row2 + 1, col1);
		}

		private int getSum(int r, int c) {
			int sum = 0;
			for (int i = r; i > 0; i -= (i & -i)) {
				for (int j = c; j > 0; j -= (j & -j)) {
					sum += tree[i][j];
				}
			}
			return sum;
		}
	}
}
