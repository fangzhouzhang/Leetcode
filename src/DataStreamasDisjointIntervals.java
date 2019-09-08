import java.util.Map;
import java.util.TreeMap;

public class DataStreamasDisjointIntervals {
	private TreeMap<Integer, int[]> map;
	/** Initialize your data structure here. */
	public DataStreamasDisjointIntervals() {
		map = new TreeMap<>();
	}

	public void addNum(int val) {
		if (map.containsKey(val)) {
			return;
		}
		Integer low = map.lowerKey(val);
		Integer high = map.higherKey(val);
		if (low != null && high != null && map.get(low)[1] + 1 == val && high == val + 1) {
			int[] arr = new int[]{map.get(low)[0], map.get(high)[1]};
			map.put(low, arr);
			map.remove(high);
		} else if (low != null && map.get(low)[1] + 1 >= val) {
			int[] arr = map.get(low);
			arr[1] = Math.max(arr[1], val);
			map.put(low, arr);
		} else if (high != null && high == val + 1) {
			int[] arr = map.get(high);
			arr[0] = val;
			map.put(val, arr);
			map.remove(high);
		} else {
			map.put(val, new int[]{val, val});
		}
	}

	public int[][] getIntervals() {
		int[][] res = new int[map.size()][2];
		int idx = 0;
		for (Map.Entry<Integer, int[]> e : map.entrySet()) {
			res[idx++] = e.getValue();
		}
		return res;
	}
}
