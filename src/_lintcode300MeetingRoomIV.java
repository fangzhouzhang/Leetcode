import java.util.Arrays;
import java.util.Comparator;

public class _lintcode300MeetingRoomIV {
	public int maxValue(int[][] meeting, int[] value) {
		// write your code here
		if (meeting == null || meeting.length == 0) return 0;
		int n = meeting.length;
		Pair[] pairs = new Pair[n];
		for (int i = 0; i < n; i++) {
			pairs[i] = new Pair(meeting[i], value[i]);
		}
		Arrays.sort(pairs, new MyComparator());
		int[] dp = new int[n];
		dp[0] = pairs[0].val;
		int res = dp[0];
		for (int i = 1; i < n; i++) {
			int localMax = pairs[i].val;
			for (int j = 0; j < i; j++) {
				if (pairs[j].interval[1] > pairs[i].interval[0]) continue;
				localMax = Math.max(localMax, dp[j] + pairs[i].val);
			}
			dp[i] = localMax;
			res = Math.max(res, dp[i]);
		}
		return res;
	}

	private class MyComparator implements Comparator<Pair> {
		public int compare(Pair a, Pair b) {
			int[] c = a.interval;
			int[] d = b.interval;
			if (c[0] != d[0]) return c[0] - d[0];
			return c[1] - d[1];
		}
	}

	private class Pair {
		int[] interval;
		int val;
		public Pair(int[] interval, int val) {
			this.interval = interval;
			this.val = val;
		}
	}
}
