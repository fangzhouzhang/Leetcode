public class SearchinRotatedSortedArray {
	/**
	 * time: o(logn) space: o(1)
	 * @param nums
	 * @param target
	 * @return
	 */
	public int search(int[] nums, int target) {
		if (nums.length == 0) {
			return -1;
		}
		int start = 0;
		int end = nums.length - 1;
		System.out.println(start + "  " + end);
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] < nums[end]) {
				if (nums[mid] < target && target <= nums[end]) {
					start = mid;
				} else {
					end = mid;
				}
			} else if (nums[start] < nums[mid]) {
				if (nums[start] <= target && target < nums[mid]) {
					end = mid;
				} else {
					start = mid;
				}
			}
		}
		if (nums[start] == target) {
			return start;
		}
		if (nums[end] == target) {
			return end;
		}
		return -1;
	}
}
