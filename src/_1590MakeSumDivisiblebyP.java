import java.util.HashMap;
import java.util.Map;

public class _1590MakeSumDivisiblebyP {
	public int minSubarray(int[] nums, int p) {
		if (nums == null || nums.length == 0) return -1;
		int rem = 0;
		for (int n : nums) {
			rem = (rem + n) % p;
		}
		if (rem == 0) return 0;
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		int n = nums.length;
		int res = n, sum = 0;
		for (int i = 0; i < n; i++) {
			sum = (sum + nums[i]) % p;
			if (sum - rem < 0) {
				if (map.containsKey((sum - rem + p) % p)) {
					res = Math.min(res, i - map.get((sum - rem + p) % p));
				}
				map.put(sum, i);
			} else {
				if (map.containsKey((sum - rem) % p)) {
					res = Math.min(res, i - map.get((sum - rem) % p));
				}
				map.put(sum, i);
			}
		}
		return res < n ? res : -1;
	}
}
