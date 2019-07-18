import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
	public int[][] insert(int[][] intervals, int[] newInterval) {
		if (intervals.length == 0 || intervals[0].length == 0) {
			return  new int[][] {{newInterval[0], newInterval[1]}};
		}
		List<int[]> res = new ArrayList<>();
		int newStart = newInterval[0];
		int idx = 0;
		while (idx < intervals.length && intervals[idx][1] < newInterval[0]) {
			res.add(intervals[idx]);
			idx++;
		}
		if (idx == intervals.length) {
			res.add(newInterval);
			int[][] ans = new int[res.size()][2];
			for (int i = 0; i < ans.length; i++) {
				ans[i][0] = res.get(i)[0];
				ans[i][1] = res.get(i)[1];
			}
			return ans;
		}
		newStart = Math.min(intervals[idx][0], newInterval[0]);
		int newEnd = newInterval[1];
		while (idx < intervals.length && intervals[idx][0] <= newInterval[1]) {
			newEnd = Math.max(intervals[idx][1], newInterval[1]);
			idx++;
		}
		res.add(new int[]{newStart, newEnd});
		while (idx < intervals.length) {
			res.add(intervals[idx]);
			idx++;
		}
		int[][] ans = new int[res.size()][2];
		for (int i = 0; i < ans.length; i++) {
			ans[i][0] = res.get(i)[0];
			ans[i][1] = res.get(i)[1];
		}
		return ans;
	}
}
