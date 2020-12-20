public class _740DeleteandEarn {
	public int deleteAndEarn(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		int max = 0;
		for (int x : nums) max = Math.max(max, x);
		Integer[] dp = new Integer[max + 1];
		int[] arr = new int[max + 1];
		for (int x : nums) arr[x]++;
		for (int i = 1; i < max + 1; i++) {
			arr[i] = i * arr[i];
		}
		return dfs(dp, arr, 1);
	}

	private int dfs(Integer[] dp, int[] a, int idx) {
		if (idx >= dp.length) return 0;
		if (dp[idx] != null) return dp[idx];
		if (a[idx] == 0) return dfs(dp, a, idx + 1);
		int res = 0;
		for (int i = idx; i < dp.length; i++) {
			res = Math.max(res, dfs(dp, a, i + 2) + a[i]);
		}
		return dp[idx] = res;
	}
}
