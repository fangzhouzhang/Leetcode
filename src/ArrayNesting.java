public class ArrayNesting {
	public int arrayNesting(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			int cnt = 1;
			while (nums[i] != i) {
				swap(nums, i, nums[i]);
				cnt++;
			}
			res = Math.max(res, cnt);
		}
		return res;
	}

	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}
