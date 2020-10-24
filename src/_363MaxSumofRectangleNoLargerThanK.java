import java.util.TreeSet;

public class _363MaxSumofRectangleNoLargerThanK {
	public int maxSumSubmatrix(int[][] matrix, int k) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
		int n = matrix.length, m = matrix[0].length;
		int[][] prefix = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				prefix[i][j] = prefix[i][j - 1] + prefix[i - 1][j] - prefix[i - 1][j - 1] + matrix[i - 1][j - 1];
			}
		}
		int res = Integer.MIN_VALUE;

		for (int j = 1; j <= m; j++) {
			for (int p = j; p <= m; p++) {
				TreeSet<Integer> set = new TreeSet<>();
				set.add(0);
				for (int i = 1; i <= n; i++) {
					int cur = calc(prefix, 1, j, i, p);
					Integer prev = set.ceiling(cur - k);
					if (prev != null) {
						res = Math.max(res, cur - prev);
					}
					set.add(cur);
				}
			}
		}
		return res;
	}

	private int calc(int[][] p, int x1, int y1, int x2, int y2) {
		return p[x2][y2] + p[x1 - 1][y1 - 1] - p[x1 - 1][y2] - p[x2][y1 - 1];
	}
}
