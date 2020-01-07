import java.util.Map;
import java.util.TreeMap;

public class _731MyCalendarII {
	private class MyCalendarTwo {
		private TreeMap<Integer, Integer> map;
		public MyCalendarTwo() {
			map = new TreeMap<>();
		}

		public boolean book(int start, int end) {
			map.put(start, map.getOrDefault(start, 0) + 1);
			map.put(end, map.getOrDefault(end, 0) - 1);
			int count = 0;
			for (Map.Entry<Integer, Integer> e : map.entrySet()) {
				count += e.getValue();
				if (count == 3) {
					map.put(start, map.getOrDefault(start, 0) - 1);
					map.put(end, map.getOrDefault(end, 0) + 1);
					return false;
				}
			}
			return true;
		}
	}
}
