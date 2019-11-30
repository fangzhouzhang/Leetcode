public class _238ProductofArrayExceptSelf {
	/**
	 * time: o(n) space: o(n)
	 * @param nums
	 * @return
	 */
	public int[] productExceptSelf(int[] nums) {
		if (nums == null || nums.length == 0) return new int[0];
		int cur = 1, n = nums.length;
		int[] res = new int[n];
		for (int i = 0; i < n; i++) {
			res[i] = cur;
			cur *= nums[i];
		}
		cur = 1;
		for (int i = n - 1; i >= 0; i--) {
			res[i] *= cur;
			cur *= nums[i];
		}
		return res;
	}
}
