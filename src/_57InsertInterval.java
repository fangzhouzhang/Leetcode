import java.util.ArrayList;
import java.util.List;

public class _57InsertInterval {
	public int[][] insert(int[][] intervals, int[] newInterval) {
		if (intervals == null || intervals.length == 0) {
			int[][] res = {newInterval};
			return res;
		}
		List<int[]> list = new ArrayList<>();
		int k = 0, n = intervals.length;
		while (k < n && intervals[k][1] < newInterval[0]) {
			list.add(intervals[k++]);
		}

		if (k < n) {
			while (k < n && intervals[k][0] <= newInterval[1]) {
				newInterval[0] = Math.min(newInterval[0], intervals[k][0]);
				newInterval[1] = Math.max(newInterval[1], intervals[k][1]);
				k++;
			}
		}
		list.add(newInterval);

		while (k < n && intervals[k][0] > newInterval[1]) {
			list.add(intervals[k++]);
		}

		n = list.size();
		int[][] res = new int[n][2];
		for (int i = 0; i < n; i++) {
			res[i][0] = list.get(i)[0];
			res[i][1] = list.get(i)[1];
		}
		return res;
	}
}
