import java.util.HashMap;
import java.util.Map;

public class PartitionEqualSubsetSum {
	public boolean canPartition(int[] nums) {
		if (nums.length == 0) {
			return true;
		}
		int sum = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int n: nums) {
			map.put(n, map.getOrDefault(n, 0) + 1);
			sum += n;
		}
		if (sum % 2 == 1) {
			return false;
		}
		// Arrays.sort(nums);
		return dfs(nums, sum/2, map);
	}

	private boolean dfs(int[] nums, int sum, Map<Integer, Integer> map) {
		if (sum == 0) {
			return true;
		}
		if (sum < 0) {
			return false;
		}
		for (Map.Entry<Integer, Integer> e: map.entrySet()) {
			if (map.get(e.getKey()) == 0) {
				continue;
			}
			map.put(e.getKey(), map.get(e.getKey()) - 1);
			if (dfs(nums, sum - e.getKey(), map)) {
				return true;
			}
			map.put(e.getKey(), map.get(e.getKey()) + 1);
		}
		return false;
	}
}
