import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _697DegreeofanArray {
	public int findShortestSubArray(int[] nums) {
		int n = nums.length;
		Map<Integer, int[]> map = new HashMap<>();
		Map<Integer, Integer> freq = new HashMap<>();
		int max = 0;
		for (int x : nums) {
			freq.put(x, freq.getOrDefault(x, 0) + 1);
			max = Math.max(max, freq.get(x));
		}
		Set<Integer> set = new HashSet<>();
		for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
			if (e.getValue() == max) set.add(e.getKey());
		}
		for (int i = 0; i < n; i++) {
			if (!set.contains(nums[i])) continue;
			if (!map.containsKey(nums[i])) {
				int[] arr = {i, i};
				map.put(nums[i], arr);
			} else {
				map.get(nums[i])[1] = i;
			}
		}
		int res = n;
		for (Map.Entry<Integer, int[]> e : map.entrySet()) {
			int[] arr = e.getValue();
			if (res > arr[1] - arr[0] + 1) res = arr[1] - arr[0] + 1;
		}
		return res;
	}
}
