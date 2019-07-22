public class FirstMissingPositive {
	public int firstMissingPositive(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 1;
		}
		for (int i = 0; i < nums.length; i++) {
			int supposedIdx = nums[i] - 1;
			while (supposedIdx >= 0 && supposedIdx < nums.length && nums[supposedIdx] != nums[i]) {
				int tmp = nums[supposedIdx];
				nums[supposedIdx] = nums[i];
				nums[i] = tmp;

				supposedIdx = nums[i] - 1;
			}
		}

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != i + 1) {
				return i + 1;
			}
		}
		return nums.length + 1;
	}
}
