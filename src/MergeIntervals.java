import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
	public int[][] merge(int[][] intervals) {
		if (intervals.length == 0) return new int[0][0];
		Arrays.sort(intervals, new MyComparator());
		List<int[]> res = new ArrayList<>();
		int start = intervals[0][0];
		int end = intervals[0][1];
		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i][0] <= end) {
				end = Math.max(end, intervals[i][1]);
			} else {
				//create new interval
				int[] interval = {start, end};
				res.add(interval);
				start = intervals[i][0];
				end = intervals[i][1];
			}
		}
		int[] interval = {start, end};
		res.add(interval);
		return res.toArray(new int[res.size()][2]);
	}

	private class MyComparator implements Comparator<int[]> {
		public int compare(int[] a, int[] b) {
			if (a[0] != b[0]) return a[0] - b[0];
			else return a[1] - b[1];
		}
	}

}
