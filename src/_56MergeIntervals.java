import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _56MergeIntervals {
	public int[][] merge(int[][] intervals) {
		if (intervals == null || intervals.length <= 1) return intervals;
		Arrays.sort(intervals, new MyComparator());
		List<int[]> res = new ArrayList<>();
		int start = intervals[0][0];
		int end = intervals[0][1];
		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i][0] <= end) {
				end = Math.max(intervals[i][1], end);
			} else {
				res.add(new int[]{start, end});
				start = intervals[i][0];
				end = intervals[i][1];
			}
		}
		res.add(new int[]{start, end});
		int[][] ans = new int[res.size()][2];
		for (int i = 0; i < ans.length; i++) {
			ans[i][0] = res.get(i)[0];
			ans[i][1] = res.get(i)[1];
		}
		return ans;
	}

	private class MyComparator implements Comparator<int[]> {
		public int compare(int[] a, int[] b) {
			if (a[0] != b[0]) return a[0] - b[0];
			else return a[1] - b[1];
		}
	}

}
