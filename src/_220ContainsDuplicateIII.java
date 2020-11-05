import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class _220ContainsDuplicateIII {
	public boolean containsNearbyAlmostDuplicateBucketSort(int[] nums, int k, int t) {
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

	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		int n = nums.length;
		TreeSet<Long> set = new TreeSet<>();
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			int add = nums[i];
			if (i - k > 0) {
				map.put(nums[i - k - 1], map.get(nums[i - k - 1]) - 1);
				if (map.get(nums[i - k - 1]) == 0) {
					set.remove((long)nums[i - k - 1]);
				}
			}
			Long above = set.ceiling((long)nums[i]);
			if (above != null) {
				if (above - (long)nums[i] <= t) return true;
			}
			Long below = set.floor((long)nums[i]);
			if (below != null) {
				if ((long)nums[i] - below <= t) return true;
			}
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
			set.add((long)nums[i]);
		}
		return false;
	}
}
