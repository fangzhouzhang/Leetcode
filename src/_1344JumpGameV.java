public class _1344JumpGameV {
	public int maxJumps(int[] arr, int d) {
		if (arr == null || arr.length == 0) return 0;
		Integer[] dp = new Integer[arr.length];
		int res = -1;
		for (int i = 0; i < arr.length; i++) res = Math.max(res, dfs(arr, dp, i, d));
		return res;
	}

	private int dfs(int[] arr, Integer[] dp, int idx, int d) {
		if (dp[idx] != null) return dp[idx];
		int max = 1;
		for (int i = 1; i <= d; i++) {
			if (idx + i < arr.length && arr[idx] <= arr[idx + i]) break;
			if (isValid(arr, idx + i)) max = Math.max(max, dfs(arr, dp, idx + i, d) + 1);
			else max = Math.max(max, 1);
		}
		for (int i = 1; i <= d; i++) {
			if (idx - i >= 0 && arr[idx - i] >= arr[idx]) break;
			if (isValid(arr, idx - i)) max = Math.max(max, dfs(arr, dp, idx - i, d) + 1);
			else max = Math.max(max, 1);
		}
		dp[idx] = max;
		return max;
	}

	private boolean isValid(int[] arr, int i) {
		if (i < 0 || i >= arr.length) return false;
		return true;
	}
}
