public class MaximumProductSubarray {
	/**
	 * time : o(n) space : o(1)
	 * @param nums
	 * @return
	 */
	public int maxProduct(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}


		int res = nums[0];
		int minSoFar = res;
		int maxSoFar = res;
		for (int i = 1; i < nums.length; i++) {
			int v1 = nums[i] * minSoFar;
			int v2 = nums[i] * maxSoFar;

			maxSoFar = Math.max(Math.max(v1, v2), nums[i]);
			minSoFar = Math.min(Math.min(v1, v2), nums[i]);
			res = Math.max(res, maxSoFar);

		}



		return res;
	}
}
