import java.util.TreeMap;

public class _729MyCalendarI {
	private class MyCalendar {
		private TreeMap<Integer, Integer> map;
		public MyCalendar() {
			map = new TreeMap<>();
		}

		public boolean book(int start, int end) {
			Integer prev = map.floorKey(start);
			Integer next = map.ceilingKey(start);
			if ((next != null && next < end) || (prev != null && start < map.get(prev))) return false;
			map.put(start, end);
			return true;
		}
	}
}
