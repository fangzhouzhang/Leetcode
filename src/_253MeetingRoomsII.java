import java.util.*;

public class _253MeetingRoomsII {
	/*
	 * time: o(nlogn) space: o(n)
	 * @param intervals
	 * @return
	 */
	public int minMeetingRooms(int[][] intervals) {
		if (intervals == null || intervals.length == 0 || intervals[0].length == 0) return 0;
		List<Point> points = new ArrayList<>();
		for (int[] interval : intervals) {
			points.add(new Point(interval[0], false));
			points.add(new Point(interval[1], true));
		}
		Collections.sort(points, new MyComparator());
		int max = 0, idx = 0, cur = 0;
		while (idx < points.size()) {
			if (!points.get(idx).isEnd) {
				cur++;
				max = Math.max(max, cur);
			} else {
				cur--;
			}
			idx++;
		}
		return max;
	}

	private class MyComparator implements Comparator<Point> {
		public int compare(Point a, Point b) {
			if (a.val != b.val) return a.val - b.val;
			else return a.isEnd ? -1 : 1;
		}
	}

	private class Point {
		int val;
		boolean isEnd;
		public Point(int val, boolean isEnd) {
			this.val = val;
			this.isEnd = isEnd;
		}
	}
}
