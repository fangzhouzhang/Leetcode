import java.util.Arrays;

public class _1727LargestSubmatrixWithRearrangements {
	int R = 0;
	int C = 0;
	public int largestSubmatrix(int[][] matrix) {
		if (matrix == null || matrix.length == 0) return 0;
		R = matrix.length;
		C = matrix[0].length;
		int[][] prefix = new int[R][C];
		for (int i = 0; i < C; i++) {
			for (int j = 0; j < R; j++) {
				if (j == 0) prefix[j][i] = matrix[j][i];
				else {
					prefix[j][i] = (matrix[j][i] == 0) ? 0 : prefix[j - 1][i] + 1;
				}
			}
		}
		int max = 0;
		for (int i = 0; i < R; i++) {
			int[] h = new int[C];
			for (int j = 0; j < C; j++) {
				h[j] = prefix[i][j];
			}
			Arrays.sort(h);
			int cur = 0;
			for (int k = 0; k < C; k++) {
				cur = Math.max(cur, h[k] * (C - 1 - k + 1));
			}
			max = Math.max(max, cur);
		}
		return max;
	}
}
