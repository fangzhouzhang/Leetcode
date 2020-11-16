import java.util.TreeMap;

public class _715RangeModule {
	/**
	 * Suppose there are n pairs in map, overlap for [left, right] is m.
	 * addRange or removeRange will be m * log(n)
	 * queryRange will be log(n)
	 */
	class RangeModule {
		TreeMap<Integer, Integer> map;
		public RangeModule() {
			map = new TreeMap<>();
		}

		public void addRange(int left, int right) {
			if (left >= right) return;
			Integer start = map.floorKey(left);
			if (start == null) start = map.ceilingKey(left);
			while (start != null && start <= right) {
				int end = map.get(start);
				if (end >= left) {
					map.remove(start);
					if (start < left) left = start;
					if (end > right) right = end;
				}
				start = map.ceilingKey(end);
			}
			map.put(left, right);
		}

		public boolean queryRange(int left, int right) {
			Integer start = map.floorKey(left);
			if (start == null || map.get(start) < right) {
				return false;
			}
			return true;
		}

		public void removeRange(int left, int right) {
			if (left >= right) return;
			Integer start = map.floorKey(left);
			if (start == null) start = map.ceilingKey(left);
			while (start != null && start < right) {
				int end = map.get(start);
				if (end > left) {
					map.remove(start);
					if (start < left) map.put(start, left);
					if (end > right) map.put(right, end);
				}
				start = map.ceilingKey(end);
			}
		}
	}

}
