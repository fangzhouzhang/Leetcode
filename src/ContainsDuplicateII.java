import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContainsDuplicateII {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		if (nums == null || nums.length < 1) {
			return false;
		}
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			List<Integer> list = null;
			if (map.containsKey(nums[i])) {
				list = map.get(nums[i]);
				list.add(i);
			} else {
				list = new ArrayList<>();
				list.add(i);
			}
			map.put(nums[i], list);
		}
		for (Integer key : map.keySet()) {
			List<Integer> list = map.get(key);
			if (list.size() < 2) {
				continue;
			}
			int start = 0;
			int end = start + 1;
			while (end < list.size()) {
				if (list.get(end) - list.get(start) <= k) {
					return true;
				} else {
					start++;
					end++;
				}
			}
		}
		return false;
	}
}
