public class AndroidUnlockPatterns {
	public int numberOfPatterns(int m, int n) {
		int[][] jumps = new int[10][10];
		jumps[1][3] = jumps[3][1] = 2;
		jumps[4][6] = jumps[6][4] = 5;
		jumps[7][9] = jumps[9][7] = 8;
		jumps[1][7] = jumps[7][1] = 4;
		jumps[2][8] = jumps[8][2] = 5;
		jumps[3][9] = jumps[9][3] = 6;
		jumps[1][9] = jumps[9][1] = jumps[3][7] = jumps[7][3] = 5;
		boolean[] visit = new boolean[10];
		int[] r1 = new int[1];
		dfs(jumps, visit, m, n, 1, r1, 1);
		int[] r2 = new int[1];
		dfs(jumps, visit, m, n, 2, r2, 1);
		int[] r3 = new int[1];
		dfs(jumps, visit, m, n, 5, r3, 1);
		return r1[0] * 4 + r2[0] * 4 + r3[0];
	}

	private void dfs(int[][] jumps, boolean[] visit, int m, int n, int start, int[] res, int len) {
		if (len > n) {
			return;
		}
		if (len >= m && len <= n) {
			res[0]++;
		}
		visit[start] = true;
		for (int i = 1; i <= 9; i++) {
			if (!visit[i] && (jumps[start][i] == 0 || visit[jumps[start][i]])) {
				dfs(jumps, visit, m, n, i, res, len + 1);
			}
		}
		visit[start] = false;
	}
}
