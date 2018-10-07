import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> res = new ArrayList<>();
		if (intervals.size() == 0) {
			return res;
		}
		Collections.sort(intervals, new IntervalComparator());
		int start = intervals.get(0).start;
		int end = intervals.get(0).end;
		for (int i = 1; i < intervals.size(); i++) {
			if (end >= intervals.get(i).start) {
				end = Math.max(end, intervals.get(i).end);
			} else {
				res.add(new Interval(start, end));
				start = intervals.get(i).start;
				end = intervals.get(i).end;
			}
		}
		res.add(new Interval(start, end));
		return res;
	}
	class IntervalComparator implements Comparator<Interval> {
		@Override
		public int compare(Interval i1, Interval i2) {
			return i1.start - i2.start;
		}
	}

	public class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}

}
