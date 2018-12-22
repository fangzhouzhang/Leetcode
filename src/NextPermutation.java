public class NextPermutation {
	/**
	 * time: o(n) space: o(1)
	 * @param nums
	 */
	public void nextPermutation(int[] nums) {
		if (nums.length <= 1) {
			return;
		}
		int partitionNumIdx = findPartitionNumIdx(nums);
		if (partitionNumIdx >= 0) {
			int changeIdx = findChangeIdx(nums, partitionNumIdx);
			if (changeIdx >= 0) {
				swap(nums, partitionNumIdx, changeIdx);
			}

		}
		reverseArray(nums, partitionNumIdx + 1);
	}
	private int findPartitionNumIdx(int[] nums) {
		for (int i = nums.length - 2; i >= 0; i--) {
			if (nums[i] < nums[i + 1]) {
				return i;
			}
		}
		return -1;
	}
	private int findChangeIdx(int[] nums, int partitionNumIdx) {
		for (int i = nums.length - 1; i >= 0; i--) {
			if (nums[i] > nums[partitionNumIdx]) {
				return i;
			}
		}
		return -1;
	}
	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	private void reverseArray(int[] nums, int startIdx) {
		int i = startIdx; int j = nums.length - 1;
		while (i <= j) {
			swap(nums, i++, j--);
		}
	}
}
