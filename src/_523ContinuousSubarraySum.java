import java.util.HashMap;
import java.util.Map;

public class _523ContinuousSubarraySum {
	public boolean checkSubarraySum(int[] nums, int k) {
		if (nums == null || nums.length < 2) return false;
		Map<Integer, Integer> map = new HashMap<>();
		/**
		 sum % k = rem
		 since (a + b) % k = a % k + b % k
		 (sum + n * k) % k = sum % k + (n * k) % k  = sum % k
		 **/
		map.put(0, 0);
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (k != 0) sum %= k;
			if (map.containsKey(sum) && i + 1 - map.get(sum) >= 2) return true;
			if (!map.containsKey(sum)) map.put(sum, i + 1);
		}
		return false;
	}
}
