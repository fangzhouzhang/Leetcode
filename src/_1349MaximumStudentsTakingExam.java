public class _1349MaximumStudentsTakingExam {
	private int col;
	public int maxStudents(char[][] seats) {
		int m = seats.length;
		int n = seats[0].length;
		col = n;
		int[] states = new int[m];
		for (int i = 0; i < m; i++) {
			int cur = 0;
			for (int j = 0; j < n; j++) {
				cur <<= 1;
				if (seats[i][j] == '.') cur += 1;
			}
			states[i] = cur;
		}
		Integer[][] dp = new Integer[m][(1 << n)];

		return dfs(states, 0, 0, dp);
	}

	private int dfs(int[] states, int i, int prevState, Integer[][] dp) {
		if (i == states.length) return 0;
		if (dp[i][prevState] != null) return dp[i][prevState];
		int max = 0;
		int curState = states[i];
		for (int k = 0; k < (1 << col); k++) {
			if ((k & curState) == k && (k & (k >> 1)) == 0) {
				if ((k & (prevState << 1)) == 0 && (k & (prevState >> 1)) == 0) {
					max = Math.max(max, Integer.bitCount(k) + dfs(states, i + 1, k, dp));
				}
			}
		}
		dp[i][prevState] = max;
		return max;
	}
}
