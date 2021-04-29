public class _1827MinimumOperationstoMaketheArrayIncreasing {
	public int minOperations(int[] nums) {
		int n = nums.length;
		int res = 0, last = nums[0];
		for (int i = 1; i < n; i++) {
			int cur = Math.max(last + 1, nums[i]);
			res += cur - nums[i];
			last = cur;
		}
		return res;
	}
}
