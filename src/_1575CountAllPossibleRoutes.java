public class _1575CountAllPossibleRoutes {
	private int M = 1000000007;
	public int countRoutes(int[] locations, int start, int finish, int fuel) {
		int n = locations.length;
		if (Math.abs(locations[start] - locations[finish]) > fuel) return 0;
		Long[][] dp = new Long[fuel + 1][n];
		return (int)dfs(locations, start, finish, fuel, dp);
	}

	private long dfs(int[] locations, int start, int finish, int fuel, Long[][] dp) {
		if (fuel < 0) return 0;
		if (dp[fuel][start] != null) return dp[fuel][start];
		long res = start == finish ? 1 : 0;
		for (int i = 0; i < locations.length; i++) {
			if (i == start) continue;
			res = (res + dfs(locations, i, finish, fuel - Math.abs(locations[i] - locations[start]), dp)) % M;
		}
		return dp[fuel][start] = res;
	}
}
