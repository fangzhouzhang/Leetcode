import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateIII {
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (nums == null || nums.length == 0 || k <= 0 || t < 0) {
			return false;
		}
		int min = Integer.MAX_VALUE;
		for (int num : nums) {
			min = Math.min(min, num);
		}

		Map<Long, Integer> map = new HashMap<>();
		long diff = Long.valueOf(t) + 1;
		for (int i = 0; i < nums.length; i++) {
			long index = (Long.valueOf(nums[i]) - Long.valueOf(min))/ diff;
			Integer prev = map.get(index - 1);
			if (prev != null && Math.abs(Long.valueOf(nums[i]) - Long.valueOf(prev)) < diff) {
				return true;
			}

			Integer post = map.get(index + 1);
			if (post != null && Math.abs(Long.valueOf(nums[i]) - Long.valueOf(post)) < diff) {
				return true;
			}

			if (map.get(index) != null) {
				return true;
			}

			map.put(index, nums[i]);
			if (i >= k) {
				map.remove((Long.valueOf(nums[i - k]) - Long.valueOf(min))/ diff);
			}
		}
		return false;
	}
}
