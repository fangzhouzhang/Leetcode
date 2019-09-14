import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class FindRightInterval {
	public int[] findRightInterval(int[][] intervals) {
		if (intervals.length == 0) {
			return new int[0];
		}
		if (intervals.length == 1) {
			return new int[]{-1};
		}
		Map<Integer, Integer> map = new HashMap<>();
		Integer[] start = new Integer[intervals.length];
		for (int i = 0; i < intervals.length; i++) {
			map.put(intervals[i][0], i);
			start[i] = intervals[i][0];
		}
		Arrays.sort(start, new MyComparator());
		int[] res = new int[intervals.length];
		int idx = 0;
		for (int[] in : intervals) {
			int i = 0;
			while (i < start.length) {
				if (in[1] > start[i]) {
					break;
				}
				i++;
			}
			res[idx++] = i > 0 ? map.get(start[i - 1]) : -1;
		}
		return res;
	}

	private class MyComparator implements Comparator<Integer> {
		public int compare(Integer a, Integer b) {
			return b - a;
		}
	}
}
