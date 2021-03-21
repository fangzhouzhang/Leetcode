public class _1799MaximizeScoreAfterNOperations {
	public int maxScore(int[] nums) {
		int n = nums.length;
		Integer[][] dp = new Integer[(1 << n) + 1][n / 2 + 1];
		return dfs(dp, nums, 0, n / 2);
	}

	private int dfs(Integer[][] dp, int[] nums, int status, int idx) {
		if (idx == 0) return 0;
		if (dp[status][idx] != null) return dp[status][idx];
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			if ((1 & (status >> i)) == 1) continue;
			for (int j = 0; j < nums.length; j++) {
				if (i == j) continue;
				if ((1 & (status >> j)) == 1) continue;
				res = Math.max(res, dfs(dp, nums, status | (1 << j) | (1 << i), idx - 1) + idx * gcd(nums[i], nums[j]));
			}
		}
		return dp[status][idx] = res;
	}

	private int gcd(int a, int b) {
		if (b == 0) return a;
		return gcd(b, a % b);
	}
}
