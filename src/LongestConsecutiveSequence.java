import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {
	public int longestConsecutive(int[] nums) {
		if (nums == null) {
			return -1;
		}
		if (nums.length < 2) {
			return nums.length;
		}

		Map<Integer, Integer> map = new HashMap<>();
		boolean[] visit = new boolean[nums.length];
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		int max = -1;
		for (int num: nums) {
			int init = num;

			while (map.containsKey(num) && visit[map.get(num)] == false) {
				visit[map.get(num)] = true;
				num--;

			}
			int lowerBound = num + 1;

			num = init + 1;
			int upperBound = 0;
			if (map.containsKey(num)) {
				while (map.containsKey(num) && visit[map.get(num)] == false) {
					visit[map.get(num)] = true;
					num++;

				}
				upperBound = num - 1;

			} else {//set does not contain init + 1, so init is upper bound
				upperBound = num - 1;
			}

			max = Math.max(max, upperBound - lowerBound + 1);
		}

		return max;
	}
}
