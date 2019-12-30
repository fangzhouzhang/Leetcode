import java.util.Arrays;
import java.util.Comparator;

public class _354RussianDollEnvelopes {
	public int maxEnvelopes(int[][] envelopes) {
		if (envelopes == null || envelopes.length == 0) return 0;
		Arrays.sort(envelopes, new MyComparator());
		Integer[] dp = new Integer[envelopes.length];
		int max = 1;
		for (int i = 0; i < envelopes.length; i++) max = Math.max(max, dfs(envelopes, i, dp));
		return max;
	}

	private class MyComparator implements Comparator<int[]> {
		public int compare(int[] a, int[] b) {
			if (a[0] != b[0]) return a[0] - b[0];
			return a[1] - b[1];
		}
	}

	private int dfs(int[][] e, int idx, Integer[] dp) {
		if (idx == e.length) return 0;
		if (dp[idx] != null) return dp[idx];
		int max = 1;
		for (int i = idx + 1; i < e.length; i++) {
			if (e[idx][0] < e[i][0] && e[idx][1] < e[i][1])
				max = Math.max(max, dfs(e, i, dp) + 1);
		}
		dp[idx] = max;
		return max;
	}
}
