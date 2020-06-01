public class _1464MaximumProductofTwoElementsinanArray {
	public int maxProduct(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		int res = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				res = Math.max(res, (nums[i] - 1) * (nums[j] - 1));
			}
		}
		return res;
	}
}
