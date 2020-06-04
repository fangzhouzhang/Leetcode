import java.util.HashMap;
import java.util.Map;

public class _220ContainsDuplicateIII {
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (nums == null || nums.length == 0 || t < 0) return false;
		int min = Integer.MAX_VALUE;
		for (int n : nums) min = Math.min(min, n);
		Map<Long, Integer> map = new HashMap<>();
		long T = (long)t + 1;
		for (int i = 0; i < nums.length; i++) {
			if (i > k) map.remove((nums[i - k - 1] - min) / T);
			long key = ((long)nums[i] - (long)min) / T;
			if (map.containsKey(key - 1) && Math.abs((long)nums[i] - (long)map.get(key - 1)) <= t) return true;
			if (map.containsKey(key)) return true;
			if (map.containsKey(key + 1) && Math.abs((long)nums[i] - (long)map.get(key + 1)) <= t) return true;
			map.put(key, nums[i]);
		}
		return false;
	}
}
