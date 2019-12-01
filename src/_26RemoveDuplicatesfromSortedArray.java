public class _26RemoveDuplicatesfromSortedArray {
    /*
     * @param nums: An ineger array
     * @return: An integer
     * time: o(n) space: o(1)
     */
	public int removeDuplicates(int[] nums) {
		if (nums == null) return -1;
		if (nums.length <= 1) return nums.length;
		int slow = 1, fast = 1;
		while (fast < nums.length) {
			if (nums[fast] == nums[slow - 1]) fast++;
			else nums[slow++] = nums[fast++];
		}
		return slow;
	}
}
