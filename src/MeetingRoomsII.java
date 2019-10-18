import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MeetingRoomsII {
	/**
	 * Definition for an interval.
	 * public class Interval {
	 *     int start;
	 *     int end;
	 *     Interval() { start = 0; end = 0; }
	 *     Interval(int s, int e) { start = s; end = e; }
	 * }
	 */
	/**
	 * time: o(nlogn) space: o(n)
	 * @param intervals
	 * @return
	 */
	public int minMeetingRooms(int[][] intervals) {
		if (intervals == null) return -1;
		if (intervals.length <= 1) return intervals.length;
		List<int[]> starts = new ArrayList<>();
		for (int[] i : intervals) starts.add(i);
		Collections.sort(starts, new StartComparator());
		List<int[]> ends = new ArrayList<>();
		for (int[] i : intervals) ends.add(i);
		Collections.sort(ends, new EndComparator());
		int cur = 0, slow = 0, fast = 0, max = -1;
		while (slow < starts.size() && fast < ends.size()) {
			if (starts.get(slow)[0] < ends.get(fast)[1]) {
				cur++;
				max = Math.max(max, cur);
				slow++;
			} else {
				cur--;
				fast++;
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
