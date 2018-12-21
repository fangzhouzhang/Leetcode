public class ProductofArrayExceptSelf {
	/**
	 * time: o(n) space: o(n)
	 * @param nums
	 * @return
	 */
	public int[] productExceptSelf(int[] nums) {
		int[] res = new int[nums.length];
		int[] frontToEnd = new int[nums.length];
		int[] endToFront = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			if (i == 0) {
				frontToEnd[i] = 1;
			} else {
				frontToEnd[i] = frontToEnd[i - 1] * nums[i - 1];
			}
		}
		for (int i = nums.length - 1; i >= 0; i--) {
			if (i == nums.length - 1) {
				endToFront[i] = 1;
			} else {
				endToFront[i] = endToFront[i + 1] * nums[i + 1];
			}
		}
		for (int i = 0; i < nums.length; i++) {
			res[i] = frontToEnd[i] * endToFront[i];
		}
		return res;
	}
	public int[] productExceptSelfI(int[] nums) {
		int[] res = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			if (i == 0) {
				res[i] = 1;
			} else {
				res[i] = res[i - 1] * nums[i - 1];
			}
		}
		int temp = 1;
		for (int i = nums.length - 1; i >= 0; i--) {
			res[i] = res[i] * temp;
			temp *= nums[i];
		}

		return res;
	}
}
