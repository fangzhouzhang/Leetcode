public class _75SortColors {
	public void sortColors(int[] nums) {
		if (nums == null || nums.length <= 1) return;
		int i = 0, j = 0, k = nums.length - 1;
		//[0, i) 0s
		//[i, j) 1s
		//[j, k] unexplored area
		//(k, n - 1] 2s
		while (j <= k) {
			if (nums[j] == 1) j++;
			else if (nums[j] == 2) swap(nums, j, k--);
			else swap(nums, j++, i++);
		}
	}

	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}
