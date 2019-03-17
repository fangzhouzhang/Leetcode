public class RemoveElement {
	public int removeElement(int[] nums, int val) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int slow = 0;
		int fast = 0;
		while (fast < nums.length) {
			if (nums[fast] != val) {
				nums[slow++] = nums[fast++];
			} else {
				fast++;
			}
		}
		return slow;
	}
}
