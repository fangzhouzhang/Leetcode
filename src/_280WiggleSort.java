public class _280WiggleSort {
	public void wiggleSort(int[] nums) {
		if (nums == null || nums.length <= 1) return;
		for (int i = 1; i < nums.length; i++) {
			if ((i % 2 == 0)) {
				if (nums[i - 1] < nums[i]) {
					swap(nums, i - 1, i);
				}
			} else {
				if (nums[i - 1] > nums[i]) {
					swap(nums, i - 1, i);
				}
			}
		}
	}

	private void swap(int[] nums, int a, int b) {
		int tmp = nums[a];
		nums[a] = nums[b];
		nums[b] = tmp;
	}
}
