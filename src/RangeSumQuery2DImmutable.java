public class RangeSumQuery2DImmutable {
	class NumMatrix {
		private int[][] prefix;
		public NumMatrix(int[][] matrix) {
			if (matrix == null || matrix.length == 0) {

			} else {
				prefix = new int[matrix[0].length][matrix.length + 1];
				calculatePrefix(prefix, matrix);
			}
		}

		public int sumRegion(int row1, int col1, int row2, int col2) {
			if (prefix == null) {
				return 0;
			}
			int[] arr = new int[col2 - col1 + 1];
			for (int i = col1; i <= col2; i++) {
				arr[i - col1] = prefix[i][row2 + 1] - prefix[i][row1];
			}
			int res = 0;
			for (int i = 0; i < arr.length; i++) {
				res += arr[i];
			}
			return res;
		}
		private void calculatePrefix(int[][] prefix, int[][] matrix) {
			for (int col = 0; col < prefix.length; col++) {
				int temp = 0;
				for (int row = 1; row < prefix[0].length; row++) {
					temp += matrix[row - 1][col];
					prefix[col][row] = temp;
				}
			}

			for (int i = 0; i < prefix.length; i++) {
				for (int j = 0; j < prefix[i].length; j++) {
					System.out.print(prefix[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}
