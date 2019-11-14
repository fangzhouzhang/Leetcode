public class _31NextPermutation {
	/**
	 * time: o(n) space: o(1)
	 * @param nums
	 */
	public void nextPermutation(int[] nums) {
		for (int i = nums.length - 1; i >= 1; i--) {
			if (nums[i - 1] < nums[i]) {
				int j = nums.length - 1;
				while (j >= i) {
					if (nums[i - 1] < nums[j]) {
						break;
					}
					j--;
				}

				swap(nums, i - 1, j);
				reverse(nums, i, nums.length - 1);
				return;
			}
		}

		reverse(nums, 0, nums.length - 1);
	}

	private void reverse(int[] nums, int start, int end) {
		while (start < end) {
			swap(nums, start, end);
			start++;
			end--;
		}
	}

	private void swap(int[] nums, int start, int end) {
		int tmp = nums[start];
		nums[start] = nums[end];
		nums[end] = tmp;
	}
}
