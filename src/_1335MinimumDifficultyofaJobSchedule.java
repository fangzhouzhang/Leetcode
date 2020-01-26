import java.util.Comparator;
import java.util.PriorityQueue;

public class _1335MinimumDifficultyofaJobSchedule {
	public int minDifficulty(int[] jobDifficulty, int d) {
		if (jobDifficulty == null || jobDifficulty.length == 0) return 0;
		if (jobDifficulty.length < d) return -1;
		Integer[][] dp = new Integer[jobDifficulty.length][d + 1];
		return dfs(jobDifficulty, 0, d, dp);
	}

	private int dfs(int[] jobDifficulty, int start, int d, Integer[][] dp) {
		if (d == 0) return 0;
		if (dp[start][d] != null) return dp[start][d];
		int min = Integer.MAX_VALUE;
		PriorityQueue<Integer> pq = new PriorityQueue<>(new MyComparator());
		for (int i = start; i <= jobDifficulty.length - d; i++) {
			pq.add(jobDifficulty[i]);
			int max = pq.peek();
			if (d == 1) {
				for (int k = i + 1; k <jobDifficulty.length; k++) max = Math.max(max, jobDifficulty[k]);
			}
			min = Math.min(min, max + dfs(jobDifficulty, i + 1, d- 1, dp));
		}
		dp[start][d] = min;
		return min;
	}

	private class MyComparator implements Comparator<Integer> {
		public int compare(Integer a, Integer b) {
			return b - a;
		}
	}
}
