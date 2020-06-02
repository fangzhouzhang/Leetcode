import java.util.HashMap;
import java.util.Map;

public class _219ContainsDuplicateII {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		if (nums == null || nums.length < 2) return false;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i <= k && i < nums.length; i++) {
			if (!map.containsKey(nums[i])) map.put(nums[i], 1);
			else map.put(nums[i], map.get(nums[i]) + 1);
			if (map.get(nums[i]) > 1) return true;
		}
		for (int i = 1 + k; i < nums.length; i++) {
			map.put(nums[i - (k + 1)], map.get(nums[i - (k + 1)]) - 1);
			if (!map.containsKey(nums[i])) map.put(nums[i], 1);
			else map.put(nums[i], map.get(nums[i]) + 1);
			if (map.get(nums[i]) > 1) return true;
		}
		return false;
	}
}
