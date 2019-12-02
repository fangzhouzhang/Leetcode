public class _91DecodeWays {
	public int numDecodings(String s) {
		if (s == null || s.length() == 0) return 0;
		Integer[] dp = new Integer[s.length() + 1];
		return dfs(s.toCharArray(), 0, dp);
	}

	private int dfs(char[] arr, int idx, Integer[] dp) {
		if (idx == arr.length) return 1;
		if (dp[idx] != null) return dp[idx];
		int ways = 0;
		if (arr[idx] != '0') ways += dfs(arr, idx + 1, dp);
		if (isValid(arr, idx)) ways += dfs(arr, idx + 2, dp);
		dp[idx] = ways;
		return ways;
	}

	private boolean isValid(char[] arr, int idx) {
		if (idx + 1 >= arr.length) return false;
		if (arr[idx] == '1') return true;
		if (arr[idx] == '2' && arr[idx + 1] <= '6') return true;
		return false;
	}
}
