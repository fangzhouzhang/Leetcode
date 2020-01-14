public class _1320MinimumDistancetoTypeaWordUsingTwoFingers {
	private int COLS = 6;
	public int minimumDistance(String word) {
		if (word == null || word.length() == 0) return 0;
		Integer[][][] dp = new Integer[word.length()][27][27];
		return dfs(word, 0, dp, 26, 26);
	}

	private int dfs(String word, int idx, Integer[][][] dp, int left, int right) {
		if (idx == word.length()) return 0;
		if (dp[idx][left][right] != null) return dp[idx][left][right];
		int min = Integer.MAX_VALUE;
		min = Math.min(min, dfs(word, idx + 1, dp, word.charAt(idx) - 'A', right) + cost(left, word.charAt(idx) - 'A'));
		min = Math.min(min, dfs(word, idx + 1, dp, left, word.charAt(idx) - 'A') + cost(right, word.charAt(idx) - 'A'));
		dp[idx][left][right] = min;
		return min;
	}

	private int cost(int i, int j) {
		if (i == 26) return 0;
		return Math.abs(i / 6 - j / 6) + Math.abs(i % 6 - j % 6);
	}
}
