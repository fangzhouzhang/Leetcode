import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PartitiontoKEqualSumSubsets {
	public boolean canPartitionKSubsets(int[] nums, int k) {
		if (nums.length == 0) {
			return true;
		}
		int total = 0;
		for (int num : nums) {
			total += num;
		}
		if (total % k != 0) {
			return false;
		}
		Arrays.sort(nums);
		int[] used = new int[nums.length];
		Map<Integer, Boolean> cache = new HashMap<>();
		return dfs(nums, used, cache, total, total / k, 0, 0);
	}
	private boolean dfs(int[] nums, int[] used, Map<Integer, Boolean> cache, int total, int portion, int p, int t) {
		if (p == portion) {
			if (t == total) {
				return true;
			} else if (t < total) {
				p = 0;
			}

		}
		if (p > portion || t > total) {
			return false;
		}
		int key = 0;
		for (int i = 0; i < used.length; i++) {
			key = key << 1;
			key = key | used[i];
		}
		if (cache.get(key) != null) {
			return cache.get(key);
		}

		for (int i = 0; i < nums.length; i++) {
			if (used[i] == 1) {
				continue;
			}
			used[i] = 1;
			if (dfs(nums, used, cache, total, portion, p + nums[i], t + nums[i])) {
				cache.put(key, true);
				return true;
			} else {
				used[i] = 0;
			}
		}
		cache.put(key, false);
		return false;
	}
}
