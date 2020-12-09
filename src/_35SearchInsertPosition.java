public class _35SearchInsertPosition {
	public int searchInsert(int[] nums, int target) {
		if (nums == null || nums.length == 0) return 0;
		if (nums[0] >= target) return 0;
		int n = nums.length;
		if (nums[n - 1] < target) return n;
		int l = 0, r = n - 1;
		while (l < r) {
			int mid = l + r >> 1;
			if (nums[mid] >= target) r = mid;
			else l = mid + 1;
		}
		return l;
	}
}
