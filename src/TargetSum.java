import java.util.HashMap;
import java.util.Map;

public class TargetSum {
	public int findTargetSumWays(int[] nums, int S) {
		if (nums.length == 0) {
			return 0;
		}
		Map<String, Integer> map = new HashMap<>();
		return dfs(nums, S, 0, map);
	}
	private int dfs(int[] nums, int rem, int idx, Map<String, Integer> map) {
		if (idx == nums.length && rem == 0) {
			return 1;
		}
		if (idx == nums.length) {
			return 0;
		}

		Integer cout = map.get(idx + "#" + rem);
		if (cout != null) {
			return cout;
		}

		int ways = 0;

		ways += dfs(nums, rem + nums[idx], idx + 1, map);

		ways += dfs(nums, rem - nums[idx], idx + 1, map);

		map.put(idx + "#" + rem, ways);
		return ways;
	}
}
