public class _1066CampusBikesII {
	public int assignBikes(int[][] workers, int[][] bikes) {
		if (workers == null || workers.length == 0) return 0;
		int n = bikes.length;
		Integer[] dp = new Integer[(1 << n)];
		return dfs(workers, bikes, 0, 0, dp);
	}

	private int dfs(int[][] workers, int[][] bikes, int workerIdx, int state, Integer[] dp) {
		if (workerIdx == workers.length) return 0;
		if (dp[state] != null) return dp[state];
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < bikes.length; i++) {
			if ((state & (1 << i)) == 0) {
				min = Math.min(min, dfs(workers, bikes, workerIdx + 1, (state | (1 << i)), dp) + Math.abs(workers[workerIdx][0] - bikes[i][0]) + Math.abs(workers[workerIdx][1] - bikes[i][1]));
			}
		}
		dp[state] = min;
		return min;
	}
}
