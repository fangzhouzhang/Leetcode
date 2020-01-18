import java.util.Map;
import java.util.TreeMap;

public class _732MyCalendarIII {
	class MyCalendarThree {
		private TreeMap<Integer, Integer> map;
		public MyCalendarThree() {
			map = new TreeMap<>();
		}

		public int book(int start, int end) {
			map.put(start, map.getOrDefault(start, 0) + 1);
			map.put(end, map.getOrDefault(end, 0) - 1);
			int max = 0, cur = 0;
			for (Map.Entry<Integer, Integer> e : map.entrySet()) {
				cur += e.getValue();
				max = Math.max(max, cur);
			}
			return max;
		}
	}
}
