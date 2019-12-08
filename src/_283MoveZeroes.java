public class _283MoveZeroes {
	/**
	 * @param nums: an integer array
	 * @return: nothing
	 * time: o(n) space: o(1)
	 */
	public void moveZeroes(int[] nums) {
		if (nums == null || nums.length == 0) return;
		int left = 0, right = 0;
		while (right < nums.length) {
			if (nums[right] == 0) right++;
			else swap(nums, left++, right++);
		}
	}

	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}

