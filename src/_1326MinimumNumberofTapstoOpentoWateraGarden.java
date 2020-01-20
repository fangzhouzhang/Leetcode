import java.util.Arrays;
import java.util.Comparator;

public class _1326MinimumNumberofTapstoOpentoWateraGarden {
	public int minTaps(int n, int[] ranges) {
		if (ranges == null || ranges.length == 0) return 0;
		int[][] intervals = new int[ranges.length][2];
		for (int i = 0; i < ranges.length; i++) intervals[i] = new int[]{i - ranges[i], i + ranges[i]};
		Arrays.sort(intervals, new MyComparator());
		if (intervals[0][0] > 0) return -1;
		int i = 0, res = 0, prevEnd = 0, curEnd = 0;
		while (prevEnd < n) {
			while (i <= n && intervals[i][0] <= prevEnd) curEnd = Math.max(curEnd, intervals[i++][1]);
			if (prevEnd == curEnd) return -1;
			prevEnd = curEnd;
			res++;
		}
		return res;
	}

	private class MyComparator implements Comparator<int[]> {
		public int compare(int[] a, int[] b) {
			return a[0] - b[0];
		}
	}
}
