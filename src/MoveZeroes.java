public class MoveZeroes {
	/**
	 * @param nums: an integer array
	 * @return: nothing
	 * time: o(n) space: o(1)
	 */
	public void moveZeroes(int[] nums) {
		// write your code here
		if (nums == null || nums.length == 0) {
			return;
		}
		int i = 0;
		int j = 0;
		for(; j < nums.length; j++) {
			if (nums[j] == 0) {
				continue;
			}
			nums[i++] = nums[j];
		}
		for (; i < nums.length; i++) {
			nums[i] = 0;
		}
	}
}

