public class _1582SpecialPositionsinaBinaryMatrix {
	public int numSpecial(int[][] mat) {
		if (mat == null || mat.length == 0) return 0;
		int rows = mat.length, cols = mat[0].length;
		int[] r = new int[rows];
		int[] c = new int[cols];
		for (int i = 0; i < rows; i++) {
			int sum = 0;
			for (int j = 0; j < cols; j++) {
				sum += mat[i][j];
			}
			r[i] = sum;
		}
		for (int i = 0; i < cols; i++) {
			int sum = 0;
			for (int j = 0; j < rows; j++) {
				sum += mat[j][i];
			}
			c[i] = sum;
		}
		int res = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (mat[i][j] == 0) continue;
				if (r[i] != 1 || c[j] != 1) continue;
				res++;
			}
		}
		return res;
	}
}
