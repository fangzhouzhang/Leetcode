import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {
	public boolean checkSubarraySum(int[] nums, int k) {
		if (nums == null || nums.length < 2) return false;
		Map<Integer, Integer> map = new HashMap<>();
		/**
		 sum % k = rem
		 since (a + b) % k = a % k + b % k
		 (sum + n * k) % k = sum % k + (n * k) % k  = sum % k
		 **/
		map.put(0, -1);//[1, 1] k = 2
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (k != 0) sum = sum % k;
			if (map.containsKey(sum)) {
				if (i - map.get(sum) >= 2) return true;
			} else map.put(sum, i);
		}
		return false;
	}
}
