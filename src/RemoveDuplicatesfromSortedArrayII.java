public class RemoveDuplicatesfromSortedArrayII {
	/**
	 * @param nums: a array of integers
	 * @return : return an integer
	 * time: o(n) space: o(1)
	 */
	public int removeDuplicates(int[] nums) {
		// write your code here
		if (nums == null) {
			return -1;
		}
		if (nums.length < 3) {
			return nums.length;
		}
		int slow = 2;
		int fast = 2;
		while (fast < nums.length) {
			while (fast < nums.length && nums[slow - 2] == nums[fast]) {
				fast++;
			}
			if (fast < nums.length && slow < nums.length) {
				nums[slow++] = nums[fast++];

			}
		}
		return slow;
	}
}
