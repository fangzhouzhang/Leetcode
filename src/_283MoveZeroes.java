public class _283MoveZeroes {
	/**
	 * @param nums: an integer array
	 * @return: nothing
	 * time: o(n) space: o(1)
	 */
	public void moveZeroes(int[] nums) {
		if (nums == null || nums.length == 0) return;
		int start = 0, end = 0;
		while (end < nums.length) {
			if (nums[end] == 0) end++;
			else {
				int tmp = nums[start];
				nums[start] = nums[end];
				nums[end] = tmp;
				start += 1;
				end += 1;
			}
		}
	}
}

