public class _1643KthSmallestInstructions {
	public String kthSmallestPath(int[] destination, int k) {
		int total = destination[0] + destination[1];
		long[][] c = new long[total + 1][total + 1];
		c[0][1] = 1;
		for (int i = 1; i <= total; i++) {
			c[i][1] = i;
			c[i][0] = 1;
		}
		for (int i = 2; i <= total; i++) {
			for (int j = 2; j <= i; j++) {
				if (i != j)
					c[i][j] = c[i - 1][j - 1] + c[i - 1][j];
				else
					c[i][j] = 1;
			}
		}
		StringBuilder sb = new StringBuilder();
		int h = destination[1], v = destination[0], rest = total;
		for (int i = 0; i < total; i++, rest--) {
			if (h == rest) {
				for (int j = 0; j < h; j++) {
					sb.append('H');
				}
				return new String(sb);
			}
			if (v == rest) {
				for (int j = 0; j < v; j++) {
					sb.append('V');
				}
				return new String(sb);
			}
			long comb = c[rest - 1][h - 1];
			if (k <= comb) {
				sb.append('H');
				h--;
			} else {
				sb.append('V');
				v--;
				k -= comb;
			}
		}
		return "";
	}
}
