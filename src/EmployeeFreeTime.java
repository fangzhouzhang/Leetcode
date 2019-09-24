import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmployeeFreeTime {
	public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
		List<Interval> res = new ArrayList<>();
		if (schedule.size() == 0) return res;
		List<Interval> schedules = new ArrayList<>();
		for (List<Interval> list: schedule) {
			for (Interval i : list) {
				schedules.add(i);
			}
		}
		Collections.sort(schedules, new MC());
		Interval prev = schedules.get(0);
		for (int i = 1; i < schedules.size(); i++) {
			if (schedules.get(i).start <= prev.end) {
				prev = prev.end < schedules.get(i).end ? schedules.get(i) : prev;
			} else {
				res.add(new Interval(prev.end, schedules.get(i).start));
				prev = schedules.get(i);
			}
		}
		return res;
	}

	private class MC implements Comparator<Interval> {
		public int compare(Interval a, Interval b) {
			if (a.start != b.start) {
				return a.start - b.start;
			} else {
				return a.end - b.end;
			}
		}
	}

	class Interval {
		public int start;
		public int end;

		public Interval() {}

		public Interval(int _start,int _end) {
			start = _start;
			end = _end;
		}
	}
}
