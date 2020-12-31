import java.util.TreeMap;

public class _1708LargestSubarrayLengthK {
	public int[] largestSubarray(int[] nums, int k) {
		TreeMap<Integer, Integer> tm = new TreeMap<>();
		int n = nums.length;
		for (int i = 0; i <= n - k; i++) {
			tm.put(nums[i], i);
		}
		int idx = tm.lastEntry().getValue();
		int[] res = new int[k];
		for (int i = 0; i < k; i++) {
			res[i] = nums[idx++];
		}
		return res;
	}
}
