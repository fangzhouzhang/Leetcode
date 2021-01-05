public class _162FindPeakElement {
	public int findPeakElement(int[] nums) {
		if (null == nums || nums.length == 0) return -1;
		int l = 0, r = nums.length - 1;
		while (l < r) {
			int mid = l + r + 1 >> 1;
			if (nums[mid - 1] < nums[mid]) l = mid;
			else r = mid - 1;
		}
		return l;
	}
}
