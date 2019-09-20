import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
	public int findMaxLength(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		//when doing nothing, no elements, sum is 0. So index is -1
		int res = 0;
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				sum -= 1;
			} else {
				sum += 1;
			}
			if (map.containsKey(sum)) {
				res = Math.max(res, i - map.get(sum));
			} else {
				map.put(sum, i);
			}
		}
		return res;
	}
}
