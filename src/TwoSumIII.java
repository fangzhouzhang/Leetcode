import java.util.HashMap;
import java.util.Map;

public class TwoSumIII {
	private Map<Integer, Integer> map;
	/** Initialize your data structure here. */
	public TwoSumIII() {
		map = new HashMap<>();
	}

	/** Add the number to an internal data structure.. */
	public void add(int number) {
		map.put(number, map.containsKey(number) ? map.get(number) + 1 : 1);
	}

	/** Find if there exists any pair of numbers which sum is equal to the value. */
	public boolean find(int value) {
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			int k = entry.getKey();
			int v = value - k;
			if ((k == v && map.get(k) >= 2) || (k != v && map.containsKey(v))) {
				return true;
			}
		}
		return false;
	}
}
