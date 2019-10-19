import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
	public int subarraySum(int[] nums, int k) {
		if (nums == null) return -1;
		if (nums.length == 0) return 0;
		int[] prefix = new int[nums.length + 1];
		int sum = 0;
		for (int i = 1; i < prefix.length; i++) {
			sum += nums[i - 1];
			prefix[i] = sum;
		}
		Map<Integer, Integer> map = new HashMap<>();
		int res = 0;
		for (int n : prefix) {
			if (map.containsKey(n - k)) res += map.get(n - k);
			map.put(n, map.getOrDefault(n, 0) + 1);
		}
		return res;
	}
}
