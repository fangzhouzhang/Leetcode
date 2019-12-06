import java.util.HashMap;
import java.util.Map;

public class _560SubarraySumEqualsK {
	public int subarraySum(int[] nums, int k) {
		if (nums == null || nums.length == 0) return 0;
		int idx = 0, sum = 0, res = 0;
		Map<Integer, Integer> map = new HashMap<>();
		while (idx < nums.length + 1) {
			if (map.containsKey(sum - k)) res += map.get(sum - k);
			map.put(sum, map.getOrDefault(sum, 0) + 1);
			if (idx < nums.length) sum += nums[idx];
			idx++;
		}
		return res;
	}
}
