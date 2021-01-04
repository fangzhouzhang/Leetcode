public class _153FindMinimuminRotatedSortedArray {
	public int findMin(int[] nums) {
		if (nums == null || nums.length == 0) return -1;
		int n = nums.length;
		int l = 0, r = n - 1;
		while (l < r) {
			int mid = l + r >> 1;
			if (nums[mid] > nums[n - 1]) l = mid + 1;
			else r = mid;
		}
		return nums[l];
	}
}
