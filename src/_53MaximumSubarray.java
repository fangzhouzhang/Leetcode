public class _53MaximumSubarray {
	public int maxSubArray(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		int n = nums.length;
		int max = nums[0];
		for (int i = 1; i < n; i++) {
			nums[i] = Math.max(nums[i], nums[i - 1] + nums[i]);
			max = Math.max(max, nums[i]);
		}
		return max;
	}
}
