import java.util.ArrayList;
import java.util.Arrays;
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
	public int minMeetingRooms(Interval[] intervals) {
		if (intervals.length <= 1) {
			return intervals.length;
		}
		int res = 0;
		int cur = 0;
		Arrays.sort(intervals, new StartComparator());
		List<Integer> start = new ArrayList<>();
		for (Interval interval: intervals) {
			start.add(interval.start);
		}
		Arrays.sort(intervals, new EndComparator());
		List<Integer> end = new ArrayList<>();
		for (Interval interval: intervals) {
			end.add(interval.end);
		}
		int slow = 0; int fast = 0;
		while (slow < start.size() && fast < end.size()) {
			if (start.get(slow) < end.get(fast)) {
				cur++;
				res = Math.max(res, cur);
				slow++;
			} else {
				cur--;
				fast++;
			}
		}
		return res;
	}


	class StartComparator implements Comparator<Interval> {
		public int compare(Interval i1, Interval i2) {
			return i1.start - i2.start;
		}
	}
	class EndComparator implements Comparator<Interval> {
		public int compare(Interval i1, Interval i2) {
			return i1.end - i2.end;
		}
	}
	class Interval {
	     int start;
	     int end;
	     Interval() { start = 0; end = 0; }
	     Interval(int s, int e) { start = s; end = e; }
	 }
}
