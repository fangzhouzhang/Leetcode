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

	public int searchI(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		int start = 0, end = nums.length - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] == target) return mid;
			if (nums[mid] >= nums[0]) {
				//first part
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		if (nums[0] <= target && target <= nums[end]) return bs(nums, 0, end, target);
		return bs(nums, end + 1, nums.length - 1, target);
	}

	private int bs(int[] a, int l, int r, int t) {
		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (a[mid] == t) return mid;
			else if (a[mid] < t) l = mid + 1;
			else r = mid - 1;
		}
		return -1;
	}
}
