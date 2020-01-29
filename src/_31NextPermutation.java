public class _31NextPermutation {
	/**
	 * time: o(n) space: o(1)
	 * @param nums
	 */
	public void nextPermutation(int[] nums) {
		if (nums == null || nums.length == 0) return;
		int idx = nums.length - 1;
		while (idx >= 1 && nums[idx] <= nums[idx - 1]) idx--;
		if (idx == 0) reverse(nums, 0, nums.length - 1);
		else {
			int firstGreater = nums.length - 1;
			while (firstGreater > idx && nums[idx - 1] >= nums[firstGreater]) firstGreater--;
			swap(nums, idx - 1, firstGreater);
			reverse(nums, idx, nums.length - 1);
		}
	}

	private void reverse(int[] nums, int start, int end) {
		while (start < end) {
			swap(nums, start, end);
			start++;
			end--;
		}
	}

	private void swap(int[] nums, int start, int end) {
		int tmp = nums[start];
		nums[start] = nums[end];
		nums[end] = tmp;
	}
}
