import java.util.HashMap;
import java.util.Map;

public class _1512NumberofGoodPairs {
	public int numIdenticalPairs(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int n : nums) {
			map.put(n, map.getOrDefault(n, 0) + 1);
		}
		int res = 0;
		for (Map.Entry<Integer, Integer> e: map.entrySet()) {
			int val = e.getValue();
			if (val <= 1) continue;
			res += val * (val - 1) / 2;
		}
		return res;
	}
}
