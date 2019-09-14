import java.util.Arrays;
import java.util.Comparator;

public class Non_overlappingIntervals {
	public int eraseOverlapIntervals(int[][] intervals) {
		if (intervals.length <= 1) {
			return 0;
		}
		int res = 0, last = 0;
		Arrays.sort(intervals, new MyComparator());
		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i][0] < intervals[last][1]) {
				res++;
				if (intervals[i][1] < intervals[last][1]) {
					last = i;
				}
			} else {
				last = i;
			}
		}
		return res;
	}

	private class MyComparator implements Comparator<int[]> {
		public int compare(int[] a, int[] b) {
			return a[0] == b[0] ? a[1] - b[1] : a[0] - b[0];
		}
	}
}
