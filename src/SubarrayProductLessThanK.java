public class SubarrayProductLessThanK {
	public int numSubarrayProductLessThanK(int[] nums, int k) {
		if (nums.length <= 1) return 0;
		int res = 0;
		int left = 0;
		int prod = 1;
		for (int i = 0; i < nums.length; i++) {
			prod *= nums[i];
			while (left <= i && prod >= k) {
				prod /= nums[left++];
			}
			res += i - left + 1;
		}
		return res;
	}
}
