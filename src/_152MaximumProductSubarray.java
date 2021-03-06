public class _152MaximumProductSubarray {
	/**
	 * time : o(n) space : o(1)
	 * @param nums
	 * @return
	 */
	public int maxProduct(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		int res = nums[0];
		int max = nums[0];
		int min = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] < 0) {
				int tmp = max;
				max = min;
				min = tmp;
			}

			max = Math.max(nums[i], nums[i] * max);
			min = Math.min(nums[i], nums[i] * min);
			res = Math.max(res, max);
		}
		return res;
	}
}
