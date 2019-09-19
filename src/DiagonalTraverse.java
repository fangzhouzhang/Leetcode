public class DiagonalTraverse {
	public int[] findDiagonalOrder(int[][] matrix) {
		if (matrix.length == 0) return new int[0];
		int[] res = new int[matrix.length * matrix[0].length];
		int r = 0, c = 0;
		int m = matrix.length;
		int n = matrix[0].length;
		for (int i = 0; i < res.length; i++) {
			res[i] = matrix[r][c];
			if ((r + c) % 2 == 0) {
				if (c == n - 1) {
					r++;
				} else if (r == 0) {
					c++;
				} else {
					r--;c++;
				}
			} else {
				if (r == m - 1) {
					c++;
				} else if (c == 0) {
					r++;
				}
				else {
					r++;c--;
				}
			}
		}
		return res;
	}
}
