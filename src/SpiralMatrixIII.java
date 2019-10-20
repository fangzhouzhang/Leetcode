public class SpiralMatrixIII {
	private int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
		int[][] res = new int[R * C][2];
		int d = 0, len = 0, i = 1;
		res[0][0] = r0;
		res[0][1] = c0;
		while (i < R * C) {
			if (d == 0 || d == 2) len++;
			for (int k = 0; k < len; k++) {
				r0 += dirs[d][0];
				c0 += dirs[d][1];
				if (r0 >= 0 && r0 < R && c0 >= 0 && c0 < C) {
					res[i][0] = r0;
					res[i][1] = c0;
					i++;
				}
			}
			d = (d + 1) % 4;
		}
		return res;
	}
}
