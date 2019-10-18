public class RangeSumQuery2DImmutable {
	class NumMatrix {
		private int[][] prefix;
		public NumMatrix(int[][] matrix) {
			if (matrix == null || matrix.length == 0) return;
			prefix = new int[matrix.length][matrix[0].length + 1];
			constructPrefix(matrix);
		}

		public int sumRegion(int row1, int col1, int row2, int col2) {
			int sum = 0;
			for (int i = row1; i <= row2; i++) {
				sum += prefix[i][col2 + 1] - prefix[i][col1];
			}
			return sum;
		}

		private void constructPrefix(int[][] matrix) {
			for (int i = 0; i < prefix.length; i++) {
				int sum = 0;
				for (int j = 1; j < prefix[i].length; j++) {
					sum += matrix[i][j - 1];
					prefix[i][j] = sum;
				}
			}
		}
	}
}
