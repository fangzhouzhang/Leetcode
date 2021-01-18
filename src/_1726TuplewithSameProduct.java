import java.util.HashMap;
import java.util.Map;

public class _1726TuplewithSameProduct {
	public int tupleSameProduct(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		int n = nums.length;
		int res = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int a = 0; a < n; a++) {
			for (int b = a + 1; b < n; b++) {
				int prod = nums[a] * nums[b];
				if (map.containsKey(prod)) res += 8 * map.get(prod);
				map.put(prod, map.getOrDefault(prod, 0) + 1);
			}
		}
		return res;
	}
}
