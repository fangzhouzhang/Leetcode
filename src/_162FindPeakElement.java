public class _162FindPeakElement {
	public int findPeakElement(int[] nums) {
		if (null == nums || nums.length == 0) return -1;
		int start = 0, end = nums.length - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			long left = (mid - 1 < 0 || mid - 1 >= nums.length) ? Long.MIN_VALUE : (long)nums[mid - 1];
			long right = (mid + 1 < 0 || mid + 1 >= nums.length) ? Long.MIN_VALUE : (long)nums[mid + 1];
			if (nums[mid] > left && nums[mid] > right) return mid;
			else if (nums[mid] < left && nums[mid] > right) {
				end = mid - 1;
			} else if (nums[mid] > left && nums[mid] < right) {
				start = mid + 1;
			} else start++;
		}
		return -1;
	}
}
