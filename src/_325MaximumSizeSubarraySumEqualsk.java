import java.util.HashMap;
import java.util.Map;

public class _325MaximumSizeSubarraySumEqualsk {
	public int maxSubArrayLen(int[] nums, int k) {
		if (nums.length == 0) {
			return 0;
		}
		int max = 0;
		int sum = 0;
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (map.containsKey(sum - k)) {
				max = Math.max(max, i - map.get(sum - k));
			}
			if (!map.containsKey(sum)) {
				map.put(sum, i);
			}
		}
		return max;
	}

	public int maxSubArrayLenI(int[] nums, int k) {
		if (nums.length == 0) {
			return 0;
		}
		int max = 0;
		int sum = 0;
		Map<Integer, Integer> map = new HashMap<>();
		int[] prefix = new int[nums.length + 1];
		for (int i = 1; i < prefix.length; i++) {
			sum += nums[i - 1];
			prefix[i] = sum;
		}
		for (int i = 0; i < prefix.length; i++) {
			if (map.containsKey(prefix[i] - k)) {
				max = Math.max(max, i - map.get(prefix[i] - k));
			}
			if (!map.containsKey(prefix[i])) map.put(prefix[i], i);
		}
		return max;
	}

	public int maxSubArrayLenII(int[] nums, int k) {
		if (nums == null || nums.length == 0) return 0;
		Map<Integer, Integer> map = new HashMap<>();
		int sum = 0, res = 0, i = 0;
		while (i < nums.length + 1) {
			if (map.containsKey(sum - k)) {
				if (i + 1 - map.get(sum - k) > res) res = i + 1 - map.get(sum - k);
			}
			if (!map.containsKey(sum)) map.put(sum, i + 1);
			if (i != nums.length) sum += nums[i];
			i++;
		}
		return res;
	}
}
