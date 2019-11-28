public class _33SearchinRotatedSortedArray {
	/**
	 * time: o(logn) space: o(1)
	 * @param nums
	 * @param target
	 * @return
	 */
	public int search(int[] nums, int target) {
		if (nums == null || nums.length == 0) return -1;
		int start = 0, end = nums.length - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] == target) return mid;
			if (nums[mid] > nums[start]) {
				if (nums[start] <= target && target < nums[mid]) end = mid - 1;
				else start = mid + 1;
			} else if (nums[mid] < nums[start]) {
				if (nums[mid] < target && target <= nums[end]) start = mid + 1;
				else end = mid - 1;
			} else start++;
		}
		return -1;
	}
}
