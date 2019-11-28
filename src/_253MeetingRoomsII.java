import java.util.*;

public class _253MeetingRoomsII {
	/*
	 * time: o(nlogn) space: o(n)
	 * @param intervals
	 * @return
	 */
	public int minMeetingRooms(int[][] intervals) {
		if (intervals == null || intervals.length == 0 || intervals[0].length == 0) return 0;
		int[][] starts = new int[intervals.length][intervals[0].length];
		Arrays.sort(intervals, new StartComparator());
		int k = 0;
		for (int[] interval : intervals) {
			starts[k][0] = interval[0];
			starts[k][1] = interval[1];
			k++;
		}
		Arrays.sort(intervals, new EndComparator());
		int cur = 0, max = 0;
		int i = 0, j = 0;
		while (i < starts.length && j < intervals.length) {
			if (starts[i][0] < intervals[j][1]) {
				i++;
				cur++;
				max = Math.max(max, cur);
			} else {
				j++;
				cur--;
			}
		}
		return max;
	}

	private class StartComparator implements Comparator<int[]> {
		public int compare(int[] a, int[] b) {
			return a[0] - b[0];
		}
	}

	private class EndComparator implements Comparator<int[]> {
		public int compare(int[] a, int[] b) {
			return a[1] - b[1];
		}
	}
}
