import java.util.*;

public class MeetingRoomsII {
	/*
	 * time: o(nlogn) space: o(n)
	 * @param intervals
	 * @return
	 */
	public int minMeetingRooms(int[][] intervals) {
		if (intervals == null) return -1;
		if (intervals.length <= 1) return intervals.length;
		List<int[]> starts = new ArrayList<>(Arrays.asList(intervals));
		starts.sort(new StartComparator());
		List<int[]> ends = new ArrayList<>(Arrays.asList(intervals));
		ends.sort(new EndComparator());
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
