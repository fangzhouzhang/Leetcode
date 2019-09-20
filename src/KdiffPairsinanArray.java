import java.util.HashMap;
import java.util.Map;

public class KdiffPairsinanArray {
	public int findPairs(int[] nums, int k) {
		if (nums.length == 0) {
			return 0;
		}
		Map<Integer, Integer> map = new HashMap<>();
		for (int n : nums) {
			map.put(n, map.getOrDefault(n, 0) + 1);
		}
		int res = 0;
		for (Map.Entry<Integer, Integer> e:map.entrySet()) {
			if (k == 0 && e.getValue() > 1) res++;
			if (k > 0 && map.containsKey(e.getKey() + k)) res++;
		}
		return res;
	}
}
