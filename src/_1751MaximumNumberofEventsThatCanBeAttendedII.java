import java.util.Arrays;
import java.util.Comparator;

public class _1751MaximumNumberofEventsThatCanBeAttendedII {
	// dp[i][j] means the max val when choosing j events from [i, n - 1]
	public int maxValue(int[][] events, int k) {
		if (events == null || events.length == 0) return 0;
		Integer[][] dp = new Integer[events.length][k + 1];
		Arrays.sort(events, new MyComparator());
		return dfs(events, 0, k, dp, -1);
	}

	private int dfs(int[][] events, int idx, int k, Integer[][] dp, int last) {
		if (idx == events.length || k == 0) return 0;
		if (dp[idx][k] != null) return dp[idx][k];
		int max = 0;
		for (int i = idx; i < events.length; i++) {
			if (events[i][0] - 1 < last) continue;
			max = Math.max(max, dfs(events, i + 1, k - 1, dp, events[i][1]) + events[i][2]);
		}
		return dp[idx][k] = max;
	}

	private class MyComparator implements Comparator<int[]> {
		public int compare(int[] a, int[] b) {
			return a[0] - b[0];
		}
	}
}
