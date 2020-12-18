import java.util.HashMap;
import java.util.Map;

public class _1679MaxNumberofKSumPairs {
	public int maxOperations(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		int count = 0;
		for (int x : nums) {
			if (map.containsKey(k - x) && map.get(k - x) > 0) {
				count++;
				map.put(k - x, map.get(k - x) - 1);
			} else {
				map.put(x, map.getOrDefault(x, 0) + 1);
			}
		}
		return count;
	}
}
