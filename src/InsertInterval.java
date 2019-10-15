import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
	public int[][] insert(int[][] intervals, int[] newInterval) {
		if (intervals.length == 0 && newInterval.length == 0) return new int[0][0];
		if (intervals.length == 0 && newInterval.length > 0) {
			int[][] arr = {newInterval};
			return arr;
		}
		int[][] newIntervals = new int[intervals.length + 1][2];
		int pos = findInsertPos(intervals, newInterval);
		for (int i = 0; i < pos; i++) {
			newIntervals[i] = intervals[i];
		}
		newIntervals[pos] = newInterval;
		for (int i = pos + 1; i < newIntervals.length; i++) {
			newIntervals[i] = intervals[i - 1];
		}
		return mergeIntervals(newIntervals);
	}

	private int[][] mergeIntervals(int[][] intervals) {
		List<int[]> res = new ArrayList<>();
		int start = intervals[0][0];
		int end = intervals[0][1];
		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i][0] <= end) {
				end = Math.max(end, intervals[i][1]);
			} else {
				int[] cur = {start, end};
				res.add(cur);
				start = intervals[i][0];
				end = intervals[i][1];
			}
		}
		int[] cur = {start, end};
		res.add(cur);
		return res.toArray(new int[res.size()][2]);
	}

	private int findInsertPos(int[][] intervals, int[] newInterval) {
		int start = 0;
		int end = intervals.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (intervals[mid][0] >= newInterval[0]) {
				end = mid;
			} else {
				start = mid;
			}
		}
		if (intervals[end][0] <= newInterval[0]) return end + 1;
		else if (intervals[start][0] <= newInterval[0]) return start + 1;
		else return 0;
	}
}
