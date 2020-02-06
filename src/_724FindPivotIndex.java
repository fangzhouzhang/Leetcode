public class _724FindPivotIndex {
	public int pivotIndex(int[] nums) {
		if (nums == null || nums.length == 0) return -1;
		int[] prefix = new int[nums.length + 1];
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			prefix[i + 1] = sum;
		}

		int n = nums.length;
		for (int i = 0; i < n; i++) {
			int left = prefix[i] - prefix[0];
			int right = prefix[n] - prefix[i + 1];
			if (left == right) return i;
		}
		return -1;
	}
}
