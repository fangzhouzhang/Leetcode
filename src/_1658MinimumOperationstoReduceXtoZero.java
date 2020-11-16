import java.util.HashMap;
import java.util.Map;

public class _1658MinimumOperationstoReduceXtoZero {
	public int minOperations(int[] nums, int x) {
		if (nums == null || nums.length == 0) return -1;
		int n = nums.length;
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 0);
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += nums[i];
		}
		if (sum == x) return n;
		int target = sum - x;
		sum = 0;
		int res = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			sum += nums[i];
			if (map.containsKey(sum - target)) {
				res = Math.max(res, i - map.get(sum - target) + 1);
			}
			if (!map.containsKey(sum)) map.put(sum, i + 1);
		}
		return res == Integer.MIN_VALUE ? -1 : n - res;
	}
}
