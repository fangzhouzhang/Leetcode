import java.util.ArrayList;
import java.util.List;

public class _57InsertInterval {
	public int[][] insert(int[][] intervals, int[] newInterval) {
		if (intervals == null || intervals.length == 0 || newInterval == null || newInterval.length == 0) return new int[][]{newInterval};
		List<int[]> res = new ArrayList<>();
		for (int[] i : intervals) {
			if (newInterval == null || i[1] < newInterval[0]) res.add(i);
			else if (newInterval[1] < i[0]) {
				res.add(newInterval);
				newInterval = null;
				res.add(i);
			} else {
				newInterval[0] = Math.min(i[0], newInterval[0]);
				newInterval[1] = Math.max(i[1], newInterval[1]);
			}
		}
		if (newInterval != null) res.add(newInterval);
		int[][] ans = new int[res.size()][2];
		int i = 0;
		for (int[] arr : res) ans[i++] = arr;
		return ans;
	}
}
