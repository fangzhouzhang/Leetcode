public class OnesandZeroes {
	public int findMaxForm(String[] strs, int m, int n) {
		if (strs.length == 0) {
			return 0;
		}
		Integer[][][] dp = new Integer[strs.length][m + 1][n + 1];
		return dfs(dp, strs, m, n, 0);
	}

	private int dfs(Integer[][][] dp, String[] strs, int m, int n, int i) {
		if (i == strs.length) {
			return 0;
		}
		if (dp[i][m][n] != null) {
			return dp[i][m][n];
		}
		int _add_cur_str = 0;
		int[] num = getNum(strs[i]);
		if (m - num[0] >= 0 && n - num[1] >= 0) {
			_add_cur_str = dfs(dp, strs, m - num[0], n - num[1], i + 1) + 1;
		}
		int _not_add = dfs(dp, strs, m, n, i + 1);
		int max = Math.max(_add_cur_str, _not_add);

		dp[i][m][n] = max;
		return max;
	}

	private int[] getNum(String s) {
		int[] arr = new int[2];
		for (char c : s.toCharArray()) {
			arr[c - '0']++;
		}
		return arr;
	}
}
