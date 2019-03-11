public class RemoveDuplicatesfromSortedArray {
    /*
     * @param nums: An ineger array
     * @return: An integer
     * time: o(n) space: o(1)
     */
	public int removeDuplicates(int[] nums) {
		if (nums.length <= 1) {
			return nums.length;
		}
		int slow = 1;
		int fast = 1;
		while (fast < nums.length) {
			if (nums[fast] != nums[slow - 1]) {
				nums[slow++] = nums[fast++];
			} else {
				fast++;
			}
		}
		return slow;
	}
}
