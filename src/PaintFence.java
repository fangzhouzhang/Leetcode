public class PaintFence {
	public int numWays(int n, int k) {
		if (n == 0 || k == 0) {
			return 0;
		}
		if (n <= 2 && k >= 2) {
			int res = 1;
			for (int i = 0; i < n; i++) {
				res *= k;
			}
			return res;
		}
		Integer[][][] mem = new Integer[n][k][2];
		return dfs(0, -1, 0, n, k, mem);
	}
	private int dfs(int idx, int prevNum, int prevCnt, int n, int k, Integer[][][] mem) {
		if (idx == n) {
			return 1;
		}

		if (prevNum != -1 && mem[idx][prevNum][prevCnt - 1] != null) {
			return mem[idx][prevNum][prevCnt - 1];
		}

		int sum = 0;
		for (int i = 0; i < k; i++) {
			if (prevNum == -1) {
				sum += dfs(idx + 1, i, 1, n, k, mem);
			} else if (prevCnt == 2) {
				if (i == prevNum) {
					continue;
				}
				sum += dfs(idx + 1, i, 1, n, k, mem);
			} else if (prevCnt == 1) {
				if (i == prevNum) {
					sum += dfs(idx + 1, i, 2, n, k, mem);
				} else {
					sum += dfs(idx + 1, i, 1, n, k, mem);
				}
			}
		}
		if (prevNum != -1) {

			mem[idx][prevNum][prevCnt - 1] = sum;
		}
		return sum;
	}
}
