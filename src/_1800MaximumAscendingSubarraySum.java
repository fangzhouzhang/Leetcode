public class _1800MaximumAscendingSubarraySum {
	public int maxAscendingSum(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		int n = nums.length;
		int[] prefix = new int[n + 1];
		int cur = 0;
		int res = 0;
		for (int i = 0; i < n; i++) {
			cur += nums[i];
			res = Math.max(res, nums[i]);
			prefix[i + 1] = cur;
		}
		for (int i = 0; i < n; i++) {
			for (int pre = i, next = i + 1; next < n; pre++, next++) {
				if (nums[pre] < nums[next]) {
					res = Math.max(res, prefix[next + 1] - prefix[i]);
				} else break;
			}
		}
		return res;
	}
}
