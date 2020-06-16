import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class _252MeetingRooms {
	public boolean canAttendMeetings(int[][] intervals) {
		if (intervals == null || intervals.length == 0) return true;
		List<Point> points = new ArrayList<>();
		for (int[] in : intervals) {
			points.add(new Point(in[0], false));
			points.add(new Point(in[1], true));
		}
		Collections.sort(points, new MyComparator());
		int max = 0, cur = 0;
		for (Point p : points) {
			if (!p.isEnd) {
				cur++;
				max = Math.max(max, cur);
			} else {
				cur--;
			}
		}
		return max <= 1;
	}

	private class MyComparator implements Comparator<Point> {
		public int compare(Point a, Point b) {
			if (a.val != b.val) return a.val - b.val;
			else {
				return a.isEnd ? -1 : 1;
			}
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
