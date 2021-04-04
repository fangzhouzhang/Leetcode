import java.util.HashMap;
import java.util.Map;

public class _1814CountNicePairsinanArray {
	private int M = 1000000007;
	public int countNicePairs(int[] nums) {
		int n = nums.length;
		int[] revs = new int[n];
		for (int i = 0; i < n; i++) {
			revs[i] = rev(nums[i]);
		}
		int res = 0;
		Map<Integer, Integer> map = new HashMap<>();
		// nums[j] - rev[j] = nums[i] - rev[i]
		for (int i = 0; i < n; i++) {
			if (map.containsKey(nums[i] - revs[i])) {
				res = (res + map.get(nums[i] - revs[i])) % M;
			}
			map.put(nums[i] - revs[i], map.getOrDefault(nums[i] - revs[i], 0)  + 1);

		}
		return res;
	}

	private int rev(int x) {
		int res = 0;
		while (x > 0) {
			res = res * 10 + x % 10;
			x /= 10;
		}
		return res;
	}
}
