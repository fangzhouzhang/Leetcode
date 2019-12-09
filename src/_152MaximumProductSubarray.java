public class _152MaximumProductSubarray {
	/**
	 * time : o(n) space : o(1)
	 * @param nums
	 * @return
	 */
	public int maxProduct(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		int res = nums[0];
		int[] arr = new int[]{nums[0], nums[0]};
		//arr[0] min arr[1] max
		for (int i = 1; i < nums.length; i++) {
			int a = nums[i] * arr[0];
			int b = nums[i] * arr[1];
			arr[0] = Math.min(Math.min(a, b), nums[i]);
			arr[1] = Math.max(Math.max(a, b), nums[i]);
			res = Math.max(res, arr[1]);
		}
		return res;
	}
}
